package com.sg.posti10r

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        supportActionBar?.hide()
        val drawPostHelper = DrawPostHelper()
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint_layout)


        val posts = Posts4Lines().createPosts()
//        logi("   size = ${posts.size} ")
//        posts.forEach { logi("${it.postText.toString()}") }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = PostAdapter(posts)
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager



       // val currentPost = FindPost().individualPost()
        // logi("${currentPost.postNum}   ")
      //  drawPostHelper.drawPost( constraintLayout, currentPost)

    }

    fun logi(message: String) {
        Log.i("gg", message)
    }
}