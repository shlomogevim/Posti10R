package com.sg.posti10r

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView



import kotlin.collections.ArrayList


class PostAdapter(val posts: ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.layout.animation=AnimationUtils.loadAnimation(holder.itemView.context,R.anim.alpha)
//        holder.layout.animation=AnimationUtils.loadAnimation(holder.itemView.context,R.anim.rotate)
//        holder.layout.animation=AnimationUtils.loadAnimation(holder.itemView.context,R.anim.scale)
//        holder.layout.animation=AnimationUtils.loadAnimation(holder.itemView.context,R.anim.translate)
        holder.bindItems(posts[position])

    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val layout = itemView?.findViewById<ConstraintLayout>(R.id.itemLayout)!!
        fun bindItems(post: Post) {
            DrawPostHelper().drawPost(layout, post)
        }
    }
}








/*
class PostAdapter(val context: Context, val posts: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    //  val util = UtilityPost()
// val base = BaseActivity()
    // val pref = context.getSharedPreferences(SHARPREF_ALMA, Context.MODE_PRIVATE)
// var movingBackgroundMode = pref.getString(SHARPREF_MOVING_BACKGROUND, FALSE)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindImage(posts[position])
        //   pref.edit().putInt(Constants.SHARPREF_CURRENT_POST_POSITION, position).apply()

    }


    override fun getItemCount() = posts.size


    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout = itemView?.findViewById<ConstraintLayout>(R.id.itemLayout)

        fun bindImage(post: Post) {
            //DrawGeneralPost().drawPost(layout, post)
        }
    }
}*/
              /* fun bindImage(post: Post) {
            pref.edit().putString(AUDIO_POSITION, FALSE).apply()
            DrawGeneralPost().drawPost(context, post, layout)
            image.setOnClickListener {
                val editor = pref.edit()
                val gson = Gson()
                val json: String = gson.toJson(post)
                editor.putString(SHARPREF_CURRENT_POST, json)
                editor.apply()
                context.startActivity(Intent(context, PostDetailesActivity::class.java))

            }
            if (post.videoText == Constants.NO_VALUE) {
                postVideoBtn.visibility=View.GONE
            } else {
                postVideoBtn.setOnClickListener {
                    val editor = pref.edit()
                    val gson = Gson()
                    val json: String = gson.toJson(post)
                    editor.putString(SHARPREF_CURRENT_POST, json)
                    editor.apply()
//                 val intent = Intent(context, VideoActivity::class.java)
//                 intent.putExtra(CURRENT_URL, post.videoUrl)
//                 context.startActivity(intent)
                    context.startActivity(Intent(context, VideoActivity::class.java))
                }
                postAudioBtn.setOnClickListener {
                    val textVideo=post.videoText
                    val intent=Intent(context, VideoExplanationActivity::class.java)
                    intent.putExtra(VIDEO_TEXT,textVideo)
                    context.startActivity(intent)
                }*/