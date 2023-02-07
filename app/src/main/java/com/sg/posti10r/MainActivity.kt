package com.sg.posti10r

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.view.animation.OvershootInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.rpc.Help
import com.sg.posti10r.tools.CenterZoomLayout
import com.sg.posti10r.tools.Helper
import jp.wasabeef.recyclerview.animators.OvershootInRightAnimator
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator

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

       val ranges = listOf(Pair(100, 103),
           Pair(29900, 29915),Pair(296, 299),
//           Pair(3999000, 3999021),Pair(3990, 39999),
//           Pair(4999050, 4999075),
//           Pair(5999000, 5999006), Pair(596, 599),
//           Pair(649, 655),
//           Pair(718, 719)
             )
       for (range in ranges) {
           FirebaseFirestore.getInstance().collection(POST_REF)
               .whereGreaterThanOrEqualTo(POST_NUM, range.first)
               .whereLessThanOrEqualTo(POST_NUM, range.second)
               .addSnapshotListener { value, error ->
                   if (value != null) {
                       for (doc in value.documents) {
                           val post = Helper().retrivePostFromFirestore(doc)
                           //post.textLocation[2]=0
                           posts.add(post)
                       }
                       createRecyclerView(posts)
                   }
               }
       }
       return posts
   }


  private fun createRecyclerView(posts: ArrayList<Post>) {
      val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
      val layoutManger = CenterZoomLayout(this)
      layoutManger.orientation = LinearLayoutManager.HORIZONTAL
      layoutManger.reverseLayout = true
      recyclerView.layoutManager = layoutManger

      val snapHelper = PagerSnapHelper()
      recyclerView.setOnFlingListener(null)
      snapHelper.attachToRecyclerView(recyclerView)

      val adapter = PostAdapter(posts)
      recyclerView.adapter = adapter
      recyclerView.setHasFixedSize(true)
      //adapter.notifyDataSetChanged()

      recyclerView.itemAnimator = SlideInUpAnimator(OvershootInterpolator(1f))




  }

    fun logi(message: String) {
        Log.i("gg", message)
    }
}
