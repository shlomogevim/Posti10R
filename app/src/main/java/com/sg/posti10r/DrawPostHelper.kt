package com.sg.posti10r

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide

class DrawPostHelper: AppCompatActivity() {
    val helper=Helper()
    lateinit var layout: ConstraintLayout
    //    lateinit var currentPost:Post
    var position1=""
    var margin1=0
    var dis1=0
    fun drawPost( constraintLayout: ConstraintLayout, currentPost: Post) {
        layout=constraintLayout
        setCurrentParameters(currentPost)
      loadImage(constraintLayout, currentPost)
      createText(constraintLayout,currentPost)

    }
    private fun setCurrentParameters(currentPost:Post) {
        //    textLocation = arrayListOf(10,-1, 33,10,0,0, 0, 0)
        val dataAr =currentPost.textLocation
        dis1 = dataAr[2]
        if (dataAr[1] == -1) {
            position1 =TOP
            margin1= dataAr[3]
        }
        if (dataAr[3] == -1) {
            position1 = BOTTOM
            margin1= dataAr[1]
        }
//        logi("56 dis1=$dis1        position1=$position1     margin1=$margin1")
    }
    private fun createText(constraintLayout: ConstraintLayout, post:Post) {
        //    textLocation = arrayListOf(10,-1, 33,10,0,0, 0, 0)
//        val mainLayout = createMainLayout(this,post)
        val mainLayout = createLinearLayout(layout.context,post)
        mainLayout.id = View.generateViewId()
        constraintLayout.addView(mainLayout)
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(mainLayout.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        constraintSet.connect(mainLayout.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        if (position1 == TOP) {
            constraintSet.connect(mainLayout.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, margin1.toPx())
        } else {
            constraintSet.connect(mainLayout.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,margin1.toPx())
        }
        constraintSet.applyTo(constraintLayout)
        //setContentView(constraintLayout)
    }
    fun createLinearLayout(context: Context,post:Post): LinearLayout {
        val ll1 = LinearLayout(context)
        ll1.orientation = LinearLayout.VERTICAL
        ll1.gravity= Gravity.CENTER_HORIZONTAL
        val textViews = createTextViews(context,post)
        for (i in textViews) {
            ll1.addView(i)
        }
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        when (position1) {
            TOP -> layoutParams.topMargin = margin1.toPx()

            BOTTOM -> layoutParams.bottomMargin =margin1.toPx()
        }
        ll1.layoutParams = layoutParams
        return ll1
    }

   private fun createTextViews(context: Context, post:Post): Array<TextView?> {
       val textViews = arrayOfNulls<TextView>(post.postText.size)
       for (index in 0 until post.postText.size) {
           textViews[index] = createTextView(context, post, index)
       }
       return textViews
   }

    private fun createTextView(context: Context, post:Post, index:Int): TextView {
        val textView = TextView(context)
        textView.id = View.generateViewId()
       textView.gravity = Gravity.CENTER_HORIZONTAL
        textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        textView.text = post.postText[index]
        textView.textSize = post.postTextSize[1].toFloat()
        textView.setTextColor(Color.parseColor(updateColor(post.postTextColor[1])))
        val shape = GradientDrawable()
        shape.cornerRadius = post.postRadiuas.toPx().toFloat()
        shape.setColor(Color.parseColor(updateColor(post.postBackground)))

        post.postBackground = post.postBackground.replace("#", "")
        post.postBackground = post.postBackground.replace("$", "")
        val tra = helper.getTransfo(post.postTransparency)
        shape.setColor(Color.parseColor("#$tra${post.postBackground}"))
        textView.background = shape
        val pad =post.postPadding
        textView.setPadding(pad[0].toPx(),pad[1].toPx(), pad[2].toPx(), pad[3].toPx())
        val typeface = helper.getFamilyFont(post.postFontFamily)
        textView.typeface = ResourcesCompat.getFont(layout.context, typeface)
        textView.setLineSpacing(0f, post.lineSpacing)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0,dis1.toPx(), 0, 0)
      layoutParams.gravity = Gravity.CENTER
        textView.layoutParams = layoutParams
        return textView

    }

    private fun loadImage(layout: ConstraintLayout, post: Post) {
        val imageView = ImageView(layout.context)
        imageView.id = View.generateViewId()
        val params = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
//        params.dimensionRatio = "H,1:1"
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
        imageView.layoutParams = params
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        layout.addView(imageView)
        Glide.with(layout.context)
            .load(post.imageUri)
            .into(imageView)
    }

    fun updateColor(str: String): String {
        return "#" + str.replace("[^A-Za-z0-9]".toRegex(), "")
    }

    fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()








}
