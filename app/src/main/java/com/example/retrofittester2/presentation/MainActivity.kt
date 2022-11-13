package com.example.retrofittester2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittester2.R
import com.example.retrofittester2.data.common.Common
import com.example.retrofittester2.data.interfaces.RetrofitServices
import com.example.retrofittester2.data.model.Movie
import com.example.retrofittester2.presentation.adapter.MyMovieAdapter
import dmax.dialog.SpotsDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: android.app.AlertDialog

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitServices
        recyclerView = findViewById(R.id.recycleMovieList)
        recyclerView.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovieLst()
    }

    private fun getAllMovieLst(){
        dialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>>{
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<MutableList<Movie>>,
                response: Response<MutableList<Movie>>
            ) {
                adapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter

                dialog.dismiss()
            }
        })
    }

}