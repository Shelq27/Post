fun main() {
    val myArrayPosts = WallService
    val myComment = comments
    val myLikes = likes
    myLikes.addLikes()
    myComment.comment = "Мой комментарий"
    var myPost = Post(1,comments = myComment, likes = myLikes)
    println(myArrayPosts.add(myPost))
    myPost = myPost.copy(date = 257890)
    myArrayPosts.update(myPost)
    println(myArrayPosts)
    println(myArrayPosts.getLastPost())


}

data class Post(
    val id: Int ,
    val fromId: Int = 0,
    val date: Long = 270123,
    val text: String = "",
    var comments: comments,
    val likes: likes,
    val postType: String = "post",
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
)

object WallService {
    private var posts = emptyArray<Post>()
    private var uId:Int = 0

    fun add(post: Post): Post {
        posts += post.copy(id=++uId)
        return posts.last()
    }

    fun update(post: Post): Boolean {

        for ((index, value) in posts.withIndex()) {
                if (post.id== value.id){
                    posts[index]=post.copy()
                }
            return true
        }
        return false
    }

    fun getLastPost(): Post {
        return posts.last()
    }
}


object comments {
    var comment: String = ""
    var canPost: Boolean = true
    var groupsCanPost: Boolean = true
    var canCclose: Boolean = true
    var canOpen: Boolean = true

    @Override
    override fun toString(): String {
        return comment
    }
}

object likes {
    private var count: Int = 0

    init {
        var userLikes: Boolean
        var canLike: Boolean
        var canPublish: Boolean
    }

    fun addLikes() {
        count++
    }

    @Override
    override fun toString(): String {
        return "$count"
    }
}




