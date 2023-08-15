import kotlin.system.exitProcess

object NoteService {
    private var notes = mutableListOf<Note>()
    private var nId: Int = 0
    fun add(note: Note): Note {
        notes += note.copy(id = ++nId)
        return notes.last()
    }

    fun createComment(note: Note, comment: Comment): Int {
        note.commentList += comment.copy(id = ++note.cId)
        return note.cId
    }

    fun deleteComment(note: Note, id: Int): Int {
        val index = id - 1
        if (index > notes.size) {
            throw CommentNotFoundException("Комментарий с номером id=$id не найдена")
        } else {
            for (comments in note.commentList) {
                if (comments.id == id) {
                    note.commentList.removeAt(index)
                }
            }
        }
        return 1
    }

    fun delete(id: Int): Int {
        val index = id - 1
        if (index > notes.size) {
            throw NoteNotFoundException("Заметка с номером id=$id не найдена")
        } else
            notes.removeAt(index)
        return 1

    }

    fun getNote() {
        println(notes)
    }

    fun getComments(note: Note) {
        println(note.commentList)

    }

}

fun main() {
    val noteOne = Note(0, "Title One", "Text One")
    val noteDouble = Note(0, "Title Two", "Text Two")
    val noteThree = Note(0, "Title Three", "Text Three")

    NoteService.add(noteOne)
    NoteService.add(noteDouble)
    NoteService.getNote()
    println()


    val myComment = Comment(0, "Text Comment")
    val myComment2 = Comment(0, "Text Comment2")
    println(NoteService.createComment(noteOne, myComment))
    println(NoteService.createComment(noteDouble, myComment))
    println(NoteService.createComment(noteOne, myComment2))
    println(NoteService.createComment(noteDouble, myComment2))
    println(NoteService.createComment(noteDouble, myComment2))
    NoteService.getNote()
    println()
    NoteService.deleteComment(noteOne, 2)
    NoteService.getComments(noteOne)
    NoteService.getNote()



}
