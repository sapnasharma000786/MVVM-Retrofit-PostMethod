package com.example.mymvvmretrofitproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmpostproject.R

import com.example.mymvvmretrofitproject.model1.getModel.Item




class BookSearchResultsAdapter :
    RecyclerView.Adapter<BookSearchResultsAdapter.BookSearchResultHolder>() {

    private var results:List<Item> = ArrayList<Item>()
    class BookSearchResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var titleTextView = itemView.findViewById(R.id.book_item_title) as TextView

         var authorsTextView = itemView.findViewById(R.id.book_item_authors)as TextView
         var publishedDateTextView = itemView.findViewById(R.id.book_item_publishedDate)as TextView
         var  smallThumbnailImageView = itemView.findViewById(R.id.book_item_smallThumbnail) as ImageView


    }

    fun setResults(results:List<Item>){
        this.results = results
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSearchResultHolder {
        val itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.book_item, parent, false)
        return BookSearchResultHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookSearchResultHolder, position: Int) {
        val item = results[position]
        holder.titleTextView.text =item.volumeInfo.title
        holder.publishedDateTextView.text = item.volumeInfo.publishedDate
        if (item.volumeInfo.authors != null)
        holder.authorsTextView.text = item.volumeInfo.authors.toString()

        if (item.volumeInfo.imageLinks != null) {
            val imageUrl: String = item.volumeInfo.imageLinks.smallThumbnail

            Glide.with(holder.itemView)
                .load(imageUrl)
                .into(holder.smallThumbnailImageView)
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }
}