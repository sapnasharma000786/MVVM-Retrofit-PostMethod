package com.example.mvvmpostproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mymvvmretrofitproject.factory.MyViewModelFactory
import com.example.mymvvmretrofitproject.model1.User
import com.example.mymvvmretrofitproject.nwt.ApiClient
import com.example.mymvvmretrofitproject.nwt.ApiInterface
import com.example.mymvvmretrofitproject.repository2.MainRepository
import com.example.mymvvmretrofitproject.viewmodel.MainViewModel

class PostMVVMActivity : AppCompatActivity() {
    private var nameEdt: EditText? = null
    private var jobEdt: EditText? = null
    private var postDataBtn: Button? = null
    private var responseTV: TextView? = null

    private var loadingPB: ProgressBar? = null
    lateinit var viewModel: MainViewModel
    private val retrofitService: ApiInterface = ApiClient.getApiData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_mvvm)
        nameEdt = findViewById(R.id.idEdtName)
        jobEdt = findViewById(R.id.idEdtJob)
        postDataBtn = findViewById(R.id.idBtnPost)
        responseTV = findViewById(R.id.idTVResponse)
        loadingPB = findViewById(R.id.idLoadingPB)
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        postDataBtn!!.setOnClickListener {
            if (nameEdt!!.getText().toString().isEmpty() && jobEdt!!.getText().toString()
                    .isEmpty()
            ) {
                Toast.makeText(
                    this@PostMVVMActivity,
                    "Please enter both the values",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            // calling a method to post the data and passing our name and job.
            postData(nameEdt!!.getText().toString(), jobEdt!!.getText().toString())
        }


    }

    private fun postData(name: String, job: String) {
        val user = User(name, job)
        viewModel.dataResponse.observe(this, Observer {
            responseTV!!.text = it
            val intent = Intent(this@PostMVVMActivity, GetMVVMActivity::class.java)
            startActivity(intent)
        })
        viewModel.errorMessage.observe(this, Observer {
            responseTV!!.text = it
        })
        viewModel.getDataUser(name, job)
    }
}