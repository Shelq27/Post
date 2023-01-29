import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addTest() {
        val service = WallService
        val myComment = comments
        val myLikes = likes
        myLikes.addLikes()
        myComment.comment = "Мой комментарий"
        val myFirstPost = Post(1,comments=myComment, likes = myLikes)
        service.add(myFirstPost)
        assertTrue(service.getLastPost().id!=0)
    }
    @Before
    fun clearBeforeTest2() {
        WallService.clear()
    }
    @Test
    fun updateTestTrue() {
        val service = WallService
        val myComment = comments
        val myLikes = likes
        myLikes.addLikes()
        myComment.comment = "Мой комментарий"
        val myFirstPost = Post(1,comments=myComment, likes = myLikes)
        val mySecondPost = Post(2,comments=myComment, likes = myLikes)
        service.add(myFirstPost)
        service.add(mySecondPost)
        val result = service.update(mySecondPost.copy(date = 290123))
        println(result)
        assertTrue(result)
    }
    @Before
    fun clearBeforeTest3() {
        WallService.clear()
    }
    @Test
    fun updateTestFalse() {
        val service = WallService
        val myComment = comments
        val myLikes = likes
        myLikes.addLikes()
        myComment.comment = "Мой комментарий"
        val myFirstPost = Post(1,comments=myComment, likes = myLikes)
        val mySecondPost = Post(2,comments=myComment, likes = myLikes)
        val myTreePost = Post(3,comments=myComment, likes = myLikes)
        service.add(myFirstPost)
        service.add(mySecondPost)
        val result = service.update(myTreePost)
        println(result)
        assertFalse(result)

    }
}