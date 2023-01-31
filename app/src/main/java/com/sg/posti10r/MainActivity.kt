package com.sg.posti10r

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.*
import com.google.firebase.firestore.FirebaseFirestore
import com.sg.posti10r.tools.CenterZoomLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        supportActionBar?.hide()

        downloadAllPost()
    }

    fun downloadAllPost(): ArrayList<Post> {
        var posts = ArrayList<Post>()
        FirebaseFirestore.getInstance().collection(POST_REF)
            // .orderBy(Constants.POST_TIME_STAMP, Query.Direction.DESCENDING)
            .whereGreaterThanOrEqualTo(POST_NUM, 4999050)
            .whereLessThanOrEqualTo(POST_NUM, 4999071)
            .addSnapshotListener { value, error ->
                if (value != null) {
                    for (doc in value.documents) {
                        val post = DownloadPostsFromFirestore().retrivePostFromFirestore(doc)
                        posts.add(post)
                    }
                    createRecyclerView(posts)
                    logi("Main posts.size=${posts.size}")
//                    pref.edit().putInt(SHARPREF_TOTAL_POSTS_SIZE, posts.size).apply()
//                    retriveGradeMapFromSharPref()
//                    savePosts()
                }
            }
        return posts
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
