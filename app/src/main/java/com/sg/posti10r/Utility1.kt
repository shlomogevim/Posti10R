package com.sg.posti10r

import android.content.Context

class Utility1(val context: Context) {

    fun getVideoText(postNum: Int): String {
        //  val fileName="v${postNum}"
        val fileName = "VideoCurrentText"
        return context.applicationContext.assets
            .open(fileName)
            .bufferedReader().use {
                it.readText()
            }
    }

    fun getPostExplanation(postNum: Int, postText: ArrayList<String>): String {

        val iniString: String = getInitPost()
        if (iniString.contains(postNum.toString())){
            return iniString
        }else {
            return postText.toString()
        }

    }

    private fun getInitPost() =
        context.applicationContext.assets
            .open("VideoCurrentText")
            .bufferedReader().use {
                it.readText()
            }


}