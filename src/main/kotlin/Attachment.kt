abstract class Attachment {
    abstract val type: String
}

class Audio {
    val id: Int = 0
    val title: String = ""
    val date: Int = 0
    val duration: Int = 0
    val url: String = ""

}

class AudioAttachment(val audio: Audio, override val type: String = "audio") : Attachment()

class Photo {
    val id: Int = 0
    val text: String = ""
    val date: Int = 0
    val width: Int = 0
    val height: Int = 0
}

class PhotoAttachment(val photo: Photo, override val type: String = "photo") : Attachment()

class Video {
    val id: Int = 0
    val title: String = ""
    val date: Int = 0
    val duration: Int = 0
    val description: String = ""
}

class VideoAttachment(val video: Video, override val type: String = "video") : Attachment()

class Note {
    val id: Int = 0
    val title: String = ""
    val date: Int = 0
    val comments: Int = 0
    val text: String = ""
}
class NoteAttachment(val note: Note, override val type: String = "note") : Attachment()
class Doc {
    val id: Int = 0
    val title: String = ""
    val date: Int = 0
    val size: Int = 0
    val url: String = ""
}
class DocAttachment(val doc: Doc, override val type: String = "doc") : Attachment()