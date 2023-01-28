package com.sg.posti10r

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.*
import com.sg.posti10r.tools.CenterZoomLayout

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
        val layoutManger = CenterZoomLayout(this)
        layoutManger.orientation = LinearLayoutManager.HORIZONTAL
        layoutManger.reverseLayout = true
        recyclerView.layoutManager =layoutManger

        val snapHelper=PagerSnapHelper()
       recyclerView.setOnFlingListener(null)
        snapHelper.attachToRecyclerView(recyclerView)

        val adapter = PostAdapter(posts)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        adapter.notifyDataSetChanged()
    }





    fun logi(message: String) {
        Log.i("gg", message)
    }
}
/* private fun createRecyclerView(posts: ArrayList<Post>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val animator = DefaultItemAnimator()
        animator.addDuration = 1000L
        animator.removeDuration = 1000L
        recyclerView.itemAnimator = animator

        val adapter = PostAdapter(posts)
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }
*/