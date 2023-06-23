package com.example.myapplicationmarvel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.json.JSONArray
import org.json.JSONObject

class MyAdapter(private val dataSet: JSONArray, val context: Context, val onclick: (JSONObject) -> Unit) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item: ConstraintLayout
        val textView: TextView
        val imageView: ImageView

        init {
            item = view.findViewById(R.id.item)
            textView = view.findViewById(R.id.textView)
            imageView = view.findViewById(R.id.imageView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet.getJSONObject(position)
        val title = item.getString("original_title")

        val imgUrl = "https://image.tmdb.org/t/p/w500" + item.getString("poster_path")

        Glide
            .with(context)
            .load(imgUrl)
            .centerCrop()
            .into(viewHolder.imageView);

        viewHolder.item.setOnClickListener { onclick(item) }
        viewHolder.textView.text = title
    }

    override fun getItemCount() = dataSet.length()
}
