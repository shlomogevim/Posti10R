package com.sg.posti10r

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class Utility() {

    fun improveColorString(st:String):String{
        var str1=st
        val ch=str1.first().toString()
        if (ch=="#"){
            str1=str1.substring(1)
        }
        return str1
    }
    fun downloadPost1(context:Context,index:Int) {
       // val layout1: ConstraintLayout = (context as Activity).findViewById(R.id.mainLayout1)
       //  val createPost1 = CreatePost1(context, layout1)

        FirebaseFirestore.getInstance().collection(POST_REF).document(index.toString()).get()
            .addOnCompleteListener { task->
                if (task.isSuccessful){
                    val post=retrivePostFromFirestore(task.result)

                  //  createPost1.drawPost(post)
                }
            }
    }

    fun retrivePostFromFirestore(snap: DocumentSnapshot?): Post {
        val postId = snap?.getLong(POST_ID)!!.toInt()
        val postNum = snap?.getLong(POST_NUM)!!.toInt()
        val lineNum = snap?.getLong(POST_LINE_NUM)!!.toInt()
        val imageUri = snap?.getString(POST_IMAGE_URI).toString()
        val postText: ArrayList<String> = snap?.get(POST_TEXT) as ArrayList<String>
        val postBackground = snap?.getString(POST_BACKGROUND).toString()
        val postTranparency = snap?.getLong(POST_TRANPARECY)!!.toInt()
        val postTextColor: ArrayList<String> = snap?.get(POST_TEXT_COLOR) as ArrayList<String>
        val postFontFamily = snap?.getLong(POST_FONT_FAMILY)!!.toInt()
        val postRadius = snap?.getLong(POST_RADIUS)!!.toInt()
        val timestamp = snap?.getTimestamp(POST_TIME_STAMP)

        val postTextSize1 = snap?.getString(POST_TEXT_SIZE).toString()
        val postTextSize: ArrayList<Int> = convertFromStringArrayToIntArry(postTextSize1)
        val postPadding1 = snap?.getString(POST_PADDING).toString()
        val postPadding: ArrayList<Int> = convertFromStringArrayToIntArry(postPadding1)
        val textLocation1 = snap?.getString(POST_TEXT_LOCATION).toString()
        val textLocation: ArrayList<Int> = convertFromStringArrayToIntArry(textLocation1)
        val postMargin1 = snap?.getString(POST_MARGIN).toString()
        val postMargin: ArrayList<ArrayList<Int>> = convertFromStringArrayToIntArry2(postMargin1)
        val postLineSpacing = snap?.getLong(POST_LINE_SPACING)!!.toFloat()

        val newPost1 = Post(
            postId,
            postNum,
            lineNum,
            imageUri,
            postText,
            postMargin,
            postBackground,
            postTranparency,
            postTextSize,
            postPadding,
            textLocation,
            postTextColor,
            postFontFamily,
            postRadius,
            timestamp,
            postLineSpacing
        )
        //logi("Utility 207   post=${newPost1}")
        return newPost1
    }

    private fun convertFromStringArrayToIntArry(str: String): ArrayList<Int> {
        var newAr = ArrayList<Int>()
        return littleHelper(str, newAr)
    }

    private fun littleHelper(str: String, arr: ArrayList<Int>): ArrayList<Int> {
        val str = str.split(",")
        for (index in 0 until str.size) {
            arr.add(str[index].trim().toInt())
        }
        return arr
    }

    private fun convertFromStringArrayToIntArry2(str: String): ArrayList<ArrayList<Int>> {
        var newAr = ArrayList<ArrayList<Int>>()

        return littleHelperForMargin(str, newAr)
    }
    private fun littleHelperForMargin(
        str: String,
        bigArray: ArrayList<ArrayList<Int>>
    ): ArrayList<ArrayList<Int>> {
        val str1 = str.replace("]", "").replace("[", "")

        var arStr = str1.split(",")
        //  logi("Utilities 250 arStr=${arStr}")
        val ind=arStr.size.div(4)
        //logi("Utility300  ind=${ind}")

        when (ind){
            1->helper10(arStr,bigArray)
            2->helper20(arStr,bigArray)
            3->helper30(arStr,bigArray)
            4->helper40(arStr,bigArray)
            5->helper50(arStr,bigArray)
            6->helper60(arStr,bigArray)
            7->helper70(arStr,bigArray)
            8->helper80(arStr,bigArray)
            9->helper90(arStr,bigArray)


        }







        return bigArray
    }

    private fun helper10(arStr: List<String>, bigArray: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        var ar1 = arrayListOf<Int>()
        for (index in 0..3) {
            ar1.add(arStr[index].trim().toInt())
            bigArray.add(0,ar1)
        }
        return bigArray
    }

    private fun helper20(arStr: List<String>, bigArray: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        var ar1 = arrayListOf<Int>()
        var ar2 = arrayListOf<Int>()

        for (index in 0..3) {
            ar1.add(arStr[index].trim().toInt())
            bigArray.add(0,ar1)
        }
        for (index in 4..7) {
            ar2.add(arStr[index].trim().toInt())
            bigArray.add(1,ar2)
        }
        return bigArray
    }

    private fun helper30(arStr: List<String>, bigArray: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        var ar1 = arrayListOf<Int>()
        var ar2 = arrayListOf<Int>()
        var ar3 = arrayListOf<Int>()

        for (index in 0..3) {
            ar1.add(arStr[index].trim().toInt())
            bigArray.add(0,ar1)
        }
        for (index in 4..7) {
            ar2.add(arStr[index].trim().toInt())
            bigArray.add(1,ar2)
        }
        for (index in 8..11) {
            ar3.add(arStr[index].trim().toInt())
            bigArray.add(2,ar3)
        }
        return bigArray
    }
    private fun helper40(arStr: List<String>, bigArray: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        var ar1 = arrayListOf<Int>()
        var ar2 = arrayListOf<Int>()
        var ar3 = arrayListOf<Int>()
        var ar4 = arrayListOf<Int>()

        for (index in 0..3) {
            ar1.add(arStr[index].trim().toInt())
            bigArray.add(0,ar1)
        }
        for (index in 4..7) {
            ar2.add(arStr[index].trim().toInt())
            bigArray.add(1,ar2)
        }
        for (index in 8..11) {
            ar3.add(arStr[index].trim().toInt())
            bigArray.add(2,ar3)
        }
        for (index in 12..15) {
            ar4.add(arStr[index].trim().toInt())
            bigArray.add(3,ar4)
        }
        return bigArray
    }

    private fun helper50(arStr: List<String>, bigArray: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        var ar0 = arrayListOf<Int>()
        var ar1 = arrayListOf<Int>()
        var ar2 = arrayListOf<Int>()
        var ar3 = arrayListOf<Int>()
        var ar4 = arrayListOf<Int>()

        for (index in 0..3) {
            ar0.add(arStr[index].trim().toInt())
            bigArray.add(0,ar0)
        }
        for (index in 4..7) {
            ar1.add(arStr[index].trim().toInt())
            bigArray.add(1,ar1)
        }
        for (index in 8..11) {
            ar2.add(arStr[index].trim().toInt())
            bigArray.add(2,ar2)
        }
        for (index in 12..15) {
            ar3.add(arStr[index].trim().toInt())
            bigArray.add(3,ar3)
        }
        for (index in 16..19) {
            ar4.add(arStr[index].trim().toInt())
            bigArray.add(4,ar4)
        }
        return bigArray
    }
    private fun helper60(arStr: List<String>, bigArray: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        var ar0 = arrayListOf<Int>()
        var ar1 = arrayListOf<Int>()
        var ar2 = arrayListOf<Int>()
        var ar3 = arrayListOf<Int>()
        var ar4 = arrayListOf<Int>()
        var ar5 = arrayListOf<Int>()


        for (index in 0..3) {
            ar0.add(arStr[index].trim().toInt())
            bigArray.add(0,ar0)
        }
        for (index in 4..7) {
            ar1.add(arStr[index].trim().toInt())
            bigArray.add(1,ar1)
        }
        for (index in 8..11) {
            ar2.add(arStr[index].trim().toInt())
            bigArray.add(2,ar2)
        }
        for (index in 12..15) {
            ar3.add(arStr[index].trim().toInt())
            bigArray.add(3,ar3)
        }
        for (index in 16..19) {
            ar4.add(arStr[index].trim().toInt())
            bigArray.add(4,ar4)
        }
        for (index in 20..23) {
            ar5.add(arStr[index].trim().toInt())
            bigArray.add(5,ar5)
        }
        return bigArray
    }
    private fun helper70(arStr: List<String>, bigArray: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        var ar0 = arrayListOf<Int>()
        var ar1 = arrayListOf<Int>()
        var ar2 = arrayListOf<Int>()
        var ar3 = arrayListOf<Int>()
        var ar4 = arrayListOf<Int>()
        var ar5 = arrayListOf<Int>()
        var ar6 = arrayListOf<Int>()

        for (index in 0..3) {
            ar0.add(arStr[index].trim().toInt())
            bigArray.add(0,ar0)
        }
        for (index in 4..7) {
            ar1.add(arStr[index].trim().toInt())
            bigArray.add(1,ar1)
        }
        for (index in 8..11) {
            ar2.add(arStr[index].trim().toInt())
            bigArray.add(2,ar2)
        }
        for (index in 12..15) {
            ar3.add(arStr[index].trim().toInt())
            bigArray.add(3,ar3)
        }
        for (index in 16..19) {
            ar4.add(arStr[index].trim().toInt())
            bigArray.add(4,ar4)
        }
        for (index in 20..23) {
            ar5.add(arStr[index].trim().toInt())
            bigArray.add(5,ar5)
        }
        for (index in 24..27) {
            ar6.add(arStr[index].trim().toInt())
            bigArray.add(6,ar6)
        }
        return bigArray
    }
    private fun helper80(arStr: List<String>, bigArray: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        var ar0 = arrayListOf<Int>()
        var ar1 = arrayListOf<Int>()
        var ar2 = arrayListOf<Int>()
        var ar3 = arrayListOf<Int>()
        var ar4 = arrayListOf<Int>()
        var ar5 = arrayListOf<Int>()
        var ar6 = arrayListOf<Int>()
        var ar7 = arrayListOf<Int>()

        for (index in 0..3) {
            ar0.add(arStr[index].trim().toInt())
            bigArray.add(0,ar0)
        }
        for (index in 4..7) {
            ar1.add(arStr[index].trim().toInt())
            bigArray.add(1,ar1)
        }
        for (index in 8..11) {
            ar2.add(arStr[index].trim().toInt())
            bigArray.add(2,ar2)
        }
        for (index in 12..15) {
            ar3.add(arStr[index].trim().toInt())
            bigArray.add(3,ar3)
        }
        for (index in 16..19) {
            ar4.add(arStr[index].trim().toInt())
            bigArray.add(4,ar4)
        }
        for (index in 20..23) {
            ar5.add(arStr[index].trim().toInt())
            bigArray.add(5,ar5)
        }
        for (index in 24..27) {
            ar6.add(arStr[index].trim().toInt())
            bigArray.add(6,ar6)
        }
        for (index in 28..31) {
            ar7.add(arStr[index].trim().toInt())
            bigArray.add(7,ar7)
        }
        return bigArray
    }
    private fun helper90(arStr: List<String>, bigArray: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        var ar0 = arrayListOf<Int>()
        var ar1 = arrayListOf<Int>()
        var ar2 = arrayListOf<Int>()
        var ar3 = arrayListOf<Int>()
        var ar4 = arrayListOf<Int>()
        var ar5 = arrayListOf<Int>()
        var ar6 = arrayListOf<Int>()
        var ar7 = arrayListOf<Int>()
        var ar8 = arrayListOf<Int>()

        for (index in 0..3) {
            ar0.add(arStr[index].trim().toInt())
            bigArray.add(0,ar0)
        }
        for (index in 4..7) {
            ar1.add(arStr[index].trim().toInt())
            bigArray.add(1,ar1)
        }
        for (index in 8..11) {
            ar2.add(arStr[index].trim().toInt())
            bigArray.add(2,ar2)
        }
        for (index in 12..15) {
            ar3.add(arStr[index].trim().toInt())
            bigArray.add(3,ar3)
        }
        for (index in 16..19) {
            ar4.add(arStr[index].trim().toInt())
            bigArray.add(4,ar4)
        }
        for (index in 20..23) {
            ar5.add(arStr[index].trim().toInt())
            bigArray.add(5,ar5)
        }
        for (index in 24..27) {
            ar6.add(arStr[index].trim().toInt())
            bigArray.add(6,ar6)
        }
        for (index in 28..31) {
            ar7.add(arStr[index].trim().toInt())
            bigArray.add(7,ar7)
        }
        for (index in 32..35) {
            ar8.add(arStr[index].trim().toInt())
            bigArray.add(8,ar8)
        }
        return bigArray
    }

  /*  fun loadCurrentPost(): Post {
        val gson = Gson()
        val json: String? = pref.getString(SHARPREF_CURRENT_POST, null)
        val type: Type = object : TypeToken<Post>() {}.type
        val post: Post = gson.fromJson(json, type)
        return post
    }*/



    fun sendPostToStringFirestore(post: Post) {
         val data = HashMap<String, Any>()
        with(post) {
            data[POST_ID] = postId
            data[POST_NUM] = postNum
            data[POST_LINE_NUM] = lineNum
            data[POST_IMAGE_URI] = imageUri
            data[POST_TEXT] = postText
            data[POST_MARGIN] = postMargin.joinToString()
            data[POST_BACKGROUND] = postBackground
            data[POST_TRANPARECY] = postTransparency
            data[POST_TEXT_SIZE] = postTextSize.joinToString()
            data[POST_PADDING] = postPadding.joinToString()
            data[POST_TEXT_LOCATION] = textLocation.joinToString()
            data[POST_TEXT_COLOR] = postTextColor
            data[POST_FONT_FAMILY] = postFontFamily
            data[POST_RADIUS] = postRadiuas
            data[POST_TIME_STAMP] = FieldValue.serverTimestamp()
            data[POST_LINE_SPACING]=lineSpacing.toDouble()
            data[POST_VIDEO_URL]=videoUrl
            data[POST_VIDEO_TEXT]=videoText
        }
        FirebaseFirestore.getInstance().collection(POST_REF).document(post.postNum.toString())
            .set(data)
    }
    fun sendPostToStringFirestoreWithoutChangingTimeStamp(post: Post) {
        val data = HashMap<String, Any>()
        with(post) {
            data[POST_ID] = postId
            data[POST_NUM] = postNum
            data[POST_LINE_NUM] = lineNum
            data[POST_IMAGE_URI] = imageUri
            data[POST_TEXT] = postText
            data[POST_MARGIN] = postMargin.joinToString()
            data[POST_BACKGROUND] = postBackground
            data[POST_TRANPARECY] = postTransparency
            data[POST_TEXT_SIZE] = postTextSize.joinToString()
            data[POST_PADDING] = postPadding.joinToString()
            data[POST_TEXT_LOCATION] = textLocation.joinToString()
            data[POST_TEXT_COLOR] = postTextColor
            data[POST_FONT_FAMILY] = postFontFamily
            data[POST_RADIUS] = postRadiuas
         // data[POST_TIME_STAMP] = FieldValue.serverTimestamp()
            data[POST_LINE_SPACING]=lineSpacing.toDouble()
            data[POST_VIDEO_URL]=videoUrl
            data[POST_VIDEO_TEXT]=videoText
        }
        FirebaseFirestore.getInstance().collection(POST_REF).document(post.postNum.toString())
            .update(data)
    }

    fun logi(
        element1: String,
        element2: String = "",
        element3: String = "",
        element4: String = ""
    ) {
        if (element1 != "" && element2 == "" && element3 == "" && element4 == "") {
            Log.d("gg", "${element1}")
        }
        if (element1 != "" && element2 != "" && element3 == "" && element4 == "") {
            Log.d("gg", "${element1} ,${element2}")
        }
        if (element1 != "" && element2 != "" && element3 != "" && element4 == "") {
            Log.d("gg", "${element1} ,${element2} ,${element3}")
        }
        if (element1 != "" && element2 != "" && element3 != "" && element4 != "") {
            Log.d("gg", "${element1} ,${element2} ${element3},${element4}")
        }
    }

   /* fun sendArticleToStringFirestore(article: Article) {
        val data = HashMap<String, Any>()
        with(article) {
            data[ARTICAL_NUM] = aricleNum
            data[ARTICAL_TEXT] = aricleText
            data[ARTICAL_TEXT_COLOR] = articleTextColor
            data[ARTICAL_TEXT_SIZE] = aricleTextSize
            data[ARTICAL_TITLE] = aricleTitle
            data[ARTICAL_BACKGROUND] = articleBackground
            data[ARTICAL_FONT_FAMILY] = articleFontFamily
            data[ARTICAL_TIMESTAMP] = FieldValue.serverTimestamp()
        }
            FirebaseFirestore.getInstance().collection(ARTICAL_REF).document(article.aricleNum.toString())
                .set(data)
        }*/
    }



