package com.example.mvvmpostproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymvvmretrofitproject.adapter.BookSearchResultsAdapter
import com.example.mymvvmretrofitproject.factory.MyViewModelFactory2
import com.example.mymvvmretrofitproject.nwt.ApiClient
import com.example.mymvvmretrofitproject.nwt.ApiInterface
import com.example.mymvvmretrofitproject.repository2.MainRepository2
import com.example.mymvvmretrofitproject.viewmodel.MainViewModel2
import com.google.android.material.textfield.TextInputEditText

class GetMVVMActivity : AppCompatActivity() {
    var bookSearchResultsAdapter: BookSearchResultsAdapter? = null
    lateinit var searchButton: Button
    lateinit var keywordEditText: TextInputEditText
    lateinit var authorEditText: TextInputEditText
    private var recyclerView : RecyclerView? = null
    lateinit var viewModel: MainViewModel2
    private val retrofitService: ApiInterface = ApiClient.getSecoendData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_mvvmactivity)
        bookSearchResultsAdapter = BookSearchResultsAdapter()
        viewModel = ViewModelProvider(this, MyViewModelFactory2(MainRepository2(retrofitService))).get(MainViewModel2::class.java)
        recyclerView = findViewById(R.id.fragment_booksearch_searchResultsRecyclerView)
        keywordEditText = findViewById(R.id.fragment_booksearch_keyword);
        authorEditText = findViewById(R.id.fragment_booksearch_author);
        searchButton = findViewById(R.id.fragment_booksearch_search);
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.adapter = bookSearchResultsAdapter

        searchButton.setOnClickListener {
            performSearch()
        }

    }

    private fun performSearch() {
        val keyword = keywordEditText.editableText.toString()
        val author = authorEditText.editableText.toString()
        viewModel.valumeResponse.observe(this, Observer {
            bookSearchResultsAdapter!!.setResults(it.items)
        })
        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this,it, Toast.LENGTH_LONG).show()
            Log.d("ADDFGG",it)
        })
        viewModel.getDataUse(keyword,author)
    }
}