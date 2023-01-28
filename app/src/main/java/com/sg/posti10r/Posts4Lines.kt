package com.sg.posti10r


class Posts4Lines {
    val util=Utility()



    private fun extractPostNumFromFunctionName(): Int {
        val func = Thread.currentThread().stackTrace.first { it.methodName.startsWith("loadPost") }
        val postNum = func.methodName.substringAfter("loadPost").toInt()
        return postNum
    }
    fun loadPost4999060():Post {   //v
        val post = Post()
        with(post) {
            postNum = 4999060
            lineNum = 4
            imageUri = "https://cdn.pixabay.com/photo/2020/08/15/08/24/aircraft-5489944_960_720.jpg"
            postText = arrayListOf(
                " אף אחד לא יוכל להאשים אותך ",
                " שלא הצלחת להמריא בחיים האלה,  ",
                " אפשר יהיה רק להאשים אותך ",
                " שלא העזת להגיע לקצה המסלול. "
            )
            postId = 87
            textLocation = arrayListOf(10,10, 0,-1,0, 0, 0, 0)
            postPadding = arrayListOf(5, 0, 5, 0)
            postTransparency =2
            postTextSize = arrayListOf(0, 16)
            val backgroundColor = "#0A174E"
            val textColor = "#F5D042"
            postFontFamily = 103
            postBackground = util.improveColorString(backgroundColor)
            val textcolo = util.improveColorString(textColor)
            val col = "#$textcolo"
            postTextColor = arrayListOf(CONSTANT, col)
            lineSpacing = 1.3f
            videoUrl = "OctwWuivve8"
//            videoText = util1.getPostExplanation(postNum, postText)
        }
       return post
    }

    fun loadPost4999061():Post {
        val post = Post()
        with(post) {
            postNum = 4999061
            lineNum = 4
            imageUri = "https://cdn.pixabay.com/photo/2017/10/17/16/10/fantasy-2861107_960_720.jpg"
            postText = arrayListOf(
                " מה שגיליתי עם הגיל ",
                " שכנראה ",
                " אני לא אצליח להיות ",
                " משהו שיותר מבן אדם. "
            )
            postId = 87
            textLocation = arrayListOf(10,0, 0,-1,0, 0, 0, 0)
            postPadding = arrayListOf(5, 0, 5, 0)
            postTransparency =4
            postTextSize = arrayListOf(0, 16)
            val backgroundColor = "#0A174E"
            val textColor = "#F5D042"
            postFontFamily = 103
            postBackground = util.improveColorString(backgroundColor)
            val textcolo = util.improveColorString(textColor)
            val col = "#$textcolo"
            postTextColor = arrayListOf(CONSTANT, col)
            lineSpacing = 1.3f
            videoUrl = "WD8jbNHRujU"
//            videoText = util1.getPostExplanation(postNum, postText)
        }
       return post
    }
    fun loadPost4999062():Post {
        val post = Post()
        with(post) {
            postNum = 4999062
            lineNum = 4
            imageUri = "https://cdn.pixabay.com/photo/2017/01/04/17/26/there-is-no-1-1952547_960_720.jpg"
            postText = arrayListOf(
                " אני חושב ",
                " משמע אני תופס את עצמי קיים,  ",
                " אני לא חושב ",
                " אני קיים ללא שום תפיסה. "
            )
            postId = 87
            textLocation = arrayListOf(10,-1, 0,10,0, 0, 0, 0)
            postPadding = arrayListOf(5, 0, 5, 0)
            postTransparency =10
            postTextSize = arrayListOf(0, 16)
            val backgroundColor = "#0A174E"
            val textColor = "#F5D042"
            postFontFamily = 103
            postBackground = util.improveColorString(backgroundColor)
            val textcolo = util.improveColorString(textColor)
            val col = "#$textcolo"
            postTextColor = arrayListOf(CONSTANT, col)
            lineSpacing = 1.3f
            videoUrl = "dGw3w_njQ4g"
//            videoText = util1.getPostExplanation(postNum, postText)
        }
      return post
    }
    fun loadPost4999063():Post {
        val post = Post()
        with(post) {
            postNum = 4999063
            lineNum = 4
            imageUri = "https://cdn.pixabay.com/photo/2018/01/09/11/04/dog-3071334_960_720.jpg"
            postText = arrayListOf(
                " לסבול בחיים ",
                " זו ברירת מחדל, ",
                " להינות ",
                " זו בחירה מודעת. "
            )
            postId = 87
            textLocation = arrayListOf(10,0, 0,-1,0, 0, 0, 0)
            postPadding = arrayListOf(10, 0,10, 0)
            postTransparency =10
            postTextSize = arrayListOf(0, 16)
            val backgroundColor = "#0A174E"
            val textColor = "#F5D042"
            postFontFamily = 103
            postBackground = util.improveColorString(backgroundColor)
            val textcolo = util.improveColorString(textColor)
            val col = "#$textcolo"
            postTextColor = arrayListOf(CONSTANT, col)
            lineSpacing = 1.3f
            videoUrl = "YYOKMUTTDdA"
//            videoText = util1.getPostExplanation(postNum, postText)
        }
      return post
    }
    fun loadPost4999064():Post {
        val post = Post()
        with(post) {
            postNum = 4999064
            lineNum = 4
            imageUri = "https://cdn.pixabay.com/photo/2018/06/29/22/45/wheat-3506758_960_720.jpg"
            postText = arrayListOf(
                " אתה יכול למדוד עכשיו ",
                " כמה השתנת מפעם, ",
                "  לפי כמה אתה מובך עכשיו ",
                " ממה שהיית פעם. "
            )
            postId = 87
            textLocation = arrayListOf(10,0, 0,-1,0, 0, 0, 0)
            postPadding = arrayListOf(10, 0, 10, 0)
            postTransparency =7
            postTextSize = arrayListOf(0, 16)
            val backgroundColor = "#0A174E"
            val textColor = "#F5D042"
            postFontFamily = 103
            postBackground = util.improveColorString(backgroundColor)
            val textcolo = util.improveColorString(textColor)
            val col = "#$textcolo"
            postTextColor = arrayListOf(CONSTANT, col)
            lineSpacing = 1.3f
            videoUrl = "KLVq0IAzh1A"
//            videoText = util1.getPostExplanation(postNum, postText)
            val postText1= arrayListOf("0.9")
//            videoText = util1.getPostExplanation(postNum, postText1)
        }
        return post
    }

    fun loadPost4999065():Post {
        val post = Post()
        with(post) {
            postNum = 4999065
            lineNum = 4
            imageUri = "https://cdn.pixabay.com/photo/2022/11/19/09/35/forest-7601671_960_720.jpg"
            postText = arrayListOf(
                " התודעה צריכה התחדשות ",
                " הנשמה יצירה ",
                "  הגוף יציבות ",
                " והאדם צריך כושר להודות בטוב. "
            )
            postId = 87
            textLocation = arrayListOf(10,5, 0,-1,0, 0, 0, 0)
            postPadding = arrayListOf(10, 0, 10, 0)
            postTransparency =10
            postTextSize = arrayListOf(0, 16)
            val backgroundColor = "#0A174E"
            val textColor = "#F5D042"
            postFontFamily = 103
            postBackground = util.improveColorString(backgroundColor)
            val textcolo = util.improveColorString(textColor)
            val col = "#$textcolo"
            postTextColor = arrayListOf(CONSTANT, col)
            videoUrl = "fPGimPUUiTs"
//            videoText = util1.getPostExplanation(postNum, postText)
        }
       return post
    }
    fun loadPost4999066():Post {
        val post = Post()
        with(post) {
            postNum = 4999066
            lineNum = 4
            imageUri = "https://cdn.pixabay.com/photo/2022/12/07/16/07/palm-7641522_960_720.jpg"
            postText = arrayListOf(
                " יש אזורי חיים נרחבים ",
                "מעבר לתחום המחשבות שלך על החיים,",
                "  אין לך כל כך קשר עם האזורים האלה ",
                " סתם בגלל שהם לא בסיבוב היומי שלך. "
            )
            postId = 87
            textLocation = arrayListOf(10,80, 0,-1,0, 0, 0, 0)
            postPadding = arrayListOf(5,5, 5,5)
            postTransparency =8
            postTextSize = arrayListOf(0, 14)
            val backgroundColor = "#DCE2F0"
            val textColor = "#50586C"
            postFontFamily = 103
            postBackground = util.improveColorString(backgroundColor)
            val textcolo = util.improveColorString(textColor)
            val col = "#$textcolo"
            postTextColor = arrayListOf(CONSTANT, col)
            videoUrl = "RM-rr0L7luE"
//            videoText = util1.getPostExplanation(postNum, postText)
        }
      return post
    }

    fun loadPost4999067():Post {
        val post = Post()
        with(post) {
            postNum = 4999067
            lineNum = 4
            imageUri = "https://cdn.pixabay.com/photo/2021/10/20/12/32/kid-6725904_960_720.jpg"
            postText = arrayListOf(
                " אם היית יודע ",
                "מה שאתה באמת",
                "  היית מפסיק להציק לעצמך ",
                " שאתה כזה. "
            )
            postId = 87
            textLocation = arrayListOf(10,20, 0,-1,0, 0, 0, 0)
            postPadding = arrayListOf(5, 0, 5, 0)
            postTransparency =10
            postTextSize = arrayListOf(0, 15)
            val backgroundColor = "#DCE2F0"
            val textColor = "#50586C"
            postFontFamily = 103
            postBackground = util.improveColorString(backgroundColor)
            val textcolo = util.improveColorString(textColor)
            val col = "#$textcolo"
            postTextColor = arrayListOf(CONSTANT, col)
            videoUrl = "_Enh46Xtp-0"
         //   videoText = util1.getPostExplanation(postNum, postText)
        }
       return post
    }

    fun loadPost4999068(): Post {
        val post = Post()
        with(post) {
            postNum= extractPostNumFromFunctionName()
            imageUri = "https://cdn.pixabay.com/photo/2019/04/16/23/59/sad-4133121_960_720.jpg"
            postText = arrayListOf(
                " כדאי שלא תצטער ",
                " אחר כך, ",
                " שפספסת את ההזדמנות שלך ",
                " להיות אחר עכשיו. "
            )
            postId = 87
            textLocation = arrayListOf(10,5, 0,-1,0, 0, 0, 0)
            postPadding = arrayListOf(0, 0, 0, 0)
            postTransparency =10
            postTextSize = arrayListOf(0, 14)
            postBackground = "#DDA94B"
            postTextColor = arrayListOf(CONSTANT,  "#1E4174")
            postFontFamily = 103
            videoUrl = "-bhNmCn--aI"
        }
        return post
    }

    fun loadPost4999069(): Post {
        val post = Post()
        with(post) {
            postNum= extractPostNumFromFunctionName()
            imageUri = "https://cdn.pixabay.com/photo/2020/04/18/12/29/landscape-5059082_960_720.jpg"
            postText = arrayListOf(
                " החיים  זו תחרות אכזרית ",
                " של להיות יותר מקובל יפה וצודק, ",
                "  מה שמוזר בתחרות המעייפת הזו  ",
                " שכולם מגיעים בסופו של דבר לאותו מקום. "
            )
            postId = 87
            textLocation = arrayListOf(10,-1, 0,10,0,0, 0, 0)
            postPadding = arrayListOf(0, 0, 0, 0)
            postTransparency =5
            postTextSize = arrayListOf(0, 14)
            postBackground =  "#0A174E"
            postTextColor = arrayListOf(CONSTANT, "#F5D042")
            postFontFamily = 103
            videoUrl = "s9HFcqzHKLQ"
        }
        return post
    }
    fun loadPost4999070(): Post {
        val post = Post()
        with(post) {
            postNum= extractPostNumFromFunctionName()
            imageUri = "https://cdn.pixabay.com/photo/2020/06/06/19/50/demonstration-5267933_960_720.jpg"
            postText = arrayListOf(
                " דמוקרטיה היא צורת שלטון ",
                " שבה לכל אחד יש את הזכות השווה ",
                "  להיות מטומטם,  ",
                " בצורה שונה. "
            )
            postId = 87
            textLocation = arrayListOf(10,-1, 0,5,0,0, 0, 0)
            postPadding = arrayListOf(0, 0, 0, 0)
            postTransparency =10
            postTextSize = arrayListOf(0, 15)
            postBackground =  "#0A174E"
            postTextColor = arrayListOf(CONSTANT, "#F5D042")
            postFontFamily = 103
            videoUrl = "5C4FnlftQt4"
        }
        return post
    }
    fun loadPost4999071(): Post {
        val post = Post()
        with(post) {
            postNum= extractPostNumFromFunctionName()
            imageUri ="https://cdn.pixabay.com/photo/2023/01/10/00/17/italy-7708552_960_720.jpg"
            postText = arrayListOf(
                " זכרון העבר  ",
                " זה מה שקרה לך בעבר,  ",
                "  טעות אישית שלך  ",
                " להכפיף את ההווה שלך לזה. "
            )
            postId = 87
            textLocation = arrayListOf(10,10,0,-1,0,0, 0, 0)  //  Top  o.k.
            postPadding = arrayListOf(0, 0, 10,0)
            postTransparency =10
            postTextSize = arrayListOf(0, 16)
            postBackground =  "#0A174E"
            postTextColor = arrayListOf(CONSTANT, "#F5D042")
            postFontFamily = 103
            videoUrl = "9UVjjcOUJLE"
        }
        return post
    }

    fun createPosts(): ArrayList<Post> {
        val posts = ArrayList<Post>()
        for (i in 4999060..4999071) {
            val postMethod = "loadPost$i"
            val method = this::class.java.getMethod(postMethod)
            val post = method.invoke(this) as Post
            posts.add(post)
        }
        return posts
    }
}