fun main() {
    val myArrayPosts = WallService
    val myComment = Comments()
    val myLikes = Likes()
    myLikes.addLikes()
    myComment.comment = "Мой комментарий"
    val myViews = Views()
    myViews.count = 100
    var myPost = Post(1, comments = myComment, likes = myLikes, views = myViews)
    val my2Post = Post(2, comments = myComment, likes = myLikes)
    println(myArrayPosts.add(myPost))
    myPost = myPost.copy(date = 257890)
    println(myArrayPosts.update(my2Post))
    println(myArrayPosts)
    println(myArrayPosts.getLastPost())
    println(my2Post)


}

data class Post(
    val id: Int,
    val ownerID: Int = 0,
    val fromId: Int = 0,
    val createdBy: String? = null,
    val date: Long = 270123,
    val text: String = "",
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments? = null,
    val copyright: Copyright? = null,
    val likes: Likes,
    val repost: Repost? = null,
    val views: Views? = null,
    val postType: String = "post",
    val postSource: String = "",
    val attachments: Array<Attachment> = emptyArray(),
    val geo: Geo? = null,
    val signerId: Int = 0,
    val copyHistory: CopyHistory? = null,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val ifFavorite: Boolean = false,
    val donut: Donut? = null,
    val postponedId: Boolean = false
)

object WallService {
    private var posts = emptyArray<Post>()
    private var uId: Int = 0

    fun clear() {
        posts = emptyArray()
        uId = 0
    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++uId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, value) in posts.withIndex()) {
            if (post.id == value.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun getLastPost(): Post {
        return posts.last()
    }
}

class Copyright {
    var id: Int = 0
    var link: String = ""
    var name: String = ""
    var type: String = ""


}

class Repost {
    val count: Int = 0
    val userReposted: Boolean = false
}

class Views {
    var count: Int = 0
    override fun toString(): String {
        return count.toString()
    }
}

class Geo {
    val type: String = ""
    val coordinates: String = ""
    val place: Place? = null
}

class Place {
    val text = "Описание места"
}

class Comments {
    var comment: String = ""
    var canPost: Boolean = true
    var groupsCanPost: Boolean = true
    var canClose: Boolean = true
    var canOpen: Boolean = true

    
    override fun toString(): String {
        return comment
    }
}

class CopyHistory {

}

class Donut {
    val isDonut: Boolean = false
    val paidDuration: Int = 100
    val placeholder: String = "Доступно с подпиской VK Donut"
    val canPublishFreeCopy: Boolean = false
    val editMore: String =
        "Вы можете изменить значения в записи " +
                "all - Вся информация о VK Donut и" +
                " duration - Время в течении которого запись" +
                "  будет доступна платным подписчиками Vk Donut"

}

class Likes {
    private var count: Int = 0

    init {
        var userLikes: Boolean
        var canLike: Boolean
        var canPublish: Boolean
    }

    fun addLikes() {
        count++
    }

    override fun toString(): String {
        return "$count"
    }
}




