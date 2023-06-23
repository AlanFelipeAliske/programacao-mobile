package com.example.myapplicationmarvel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun onclickAdapter(it: JSONObject) {
        Log.v("onclick", it.toString())
        val intent = Intent(this, DetailsActivity::class.java)
        val bundle = Bundle()
        //bundle.putString("key", it.toString())
        intent.putExtra("key", it.toString())
        startActivity(intent)
    }

    fun getData (){
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.themoviedb.org/3/movie/popular?api_key=04c1d219612b5f28b8117f7721983c05"

        // Request a string response from the provided URL.
        val stringRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                Log.v("tag", response.toString())
                adapter = MyAdapter(response.getJSONArray("results"), this ){onclickAdapter(it)}

                var list = findViewById<RecyclerView>(R.id.list)
                list.layoutManager = LinearLayoutManager(this)

                list.adapter = adapter

                // Display the first 500 characters of the response string.
                //textView.text = "Response is: ${response.substring(0, 500)}"
            },
            {
            //    textView.text = "That didn't work!"
                Log.v("tag", "erro")
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}