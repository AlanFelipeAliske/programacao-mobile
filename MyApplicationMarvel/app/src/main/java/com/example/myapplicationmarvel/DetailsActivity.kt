package com.example.myapplicationmarvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.json.JSONObject

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val data = intent.extras?.getString("key", "")

        val dataObject = JSONObject(data)

        val title = dataObject.getString("original_title")
        val titleViewDetails = findViewById<TextView>(R.id.titleViewDetails)
        titleViewDetails.text = title

        val overview = dataObject.getString("overview")
        val overviewViewDetails  = findViewById<TextView>(R.id.overviewDetails)
        overviewViewDetails.text = overview

        val imgUrl = "https://image.tmdb.org/t/p/w500" + dataObject.getString("poster_path")

        var imageViewDetails = findViewById<ImageView>(R.id.imageViewDetails)


        Glide
            .with(this)
            .load(imgUrl)
            .centerCrop()
            .into(imageViewDetails);

    }
}