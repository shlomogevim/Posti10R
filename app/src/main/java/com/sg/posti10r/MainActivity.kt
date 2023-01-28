package com.sg.posti10r

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        supportActionBar?.hide()
        val drawPostHelper = DrawPostHelper()
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint_layout)


        val posts = Posts4Lines().createPosts()
         createRecyclerView(posts)
//        posts.forEach { logi("${it.postText.toString()}") }


    }
    private fun createRecyclerView(posts: ArrayList<Post>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
       // val adapter = PostAdapter(posts)
//        recyclerView.adapter = adapter
        recyclerView.adapter = FlipCardAdapter(posts)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }






   /* private fun createRecyclerView(posts: ArrayList<Post>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = PostAdapter(posts)
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
    }*/
    /* private fun create_rvPost() {
        val layoutManger = CenterZoomLayout(this)
        layoutManger.orientation = LinearLayoutManager.HORIZONTAL
        layoutManger.reverseLayout = true
        // layoutManger.stackFromEnd=true
        rvPosts.layoutManager = layoutManger

//        val snapHelper = LinearSnapHelper()
//        rvPosts.setOnFlingListener(null)
//        snapHelper.attachToRecyclerView(rvPosts)

        val snapHelper1=PagerSnapHelper()
        rvPosts.setOnFlingListener(null)
        snapHelper1.attachToRecyclerView(rvPosts)


        rvPosts.isNestedScrollingEnabled = false
        postAdapter = PostAdapter(this, posts)
        rvPosts.adapter = postAdapter
        rvPosts.setHasFixedSize(true)
        postAdapter.notifyDataSetChanged()
    }*/

    fun logi(message: String) {
        Log.i("gg", message)
    }
}