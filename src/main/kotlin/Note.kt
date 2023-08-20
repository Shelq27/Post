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

    fun delete(noteId: Int): Int {
        val iterator = notes.listIterator()
        for (note in iterator) {
            if (note.id == noteId) {
                notes.remove(note)
                return 1
            }
        }
        return 0
    }

    fun deleteComment(note: Note, commentId: Int): Int {
        for ((indexList, comment) in note.commentList.withIndex()) {
            if (comment.id == commentId) {
                note.deleteCommentList += note.commentList[indexList]
                note.commentList.removeAt(indexList)
                return 1
            }
        }
        return 0
    }


    fun edit(noteId: Int, editTitle: String, editText: String): Int {
        for ((indexList, note) in notes.withIndex()) {
            if (note.id == noteId) {
                notes[indexList]=note.copy(text = editText, title = editTitle)
                return 1
            }
        }
        return 0
    }
    fun editComment(note: Note,commentId: Int,commentMessage:String):Int{
        for ((indexList, comment) in note.commentList.withIndex()) {
            if (comment.id == commentId) {
                note.commentList[indexList]=comment.copy(message = commentMessage)
                return 1
            }
        }
        return 0
    }

    fun restoreComment(note: Note, delCommentId: Int): Int {
        for ((indexDelList, comment) in note.deleteCommentList.withIndex()) {
            if (comment.id == delCommentId) {
                note.commentList += note.deleteCommentList[indexDelList]
                note.deleteCommentList.removeAt(indexDelList)
                return 1
            }
        }
        return 0
    }


    fun getNote() {
        println(notes)
    }

    fun getNoteById(noteId: Int) {
        val iterator = notes.listIterator()
        for (note in iterator) {
            if (note.id == noteId) {
                println(note)
            }
        }
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
    NoteService.createComment(noteOne, myComment)
    NoteService.createComment(noteDouble, myComment)
    NoteService.createComment(noteOne, myComment2)
    NoteService.createComment(noteDouble, myComment2)
    NoteService.createComment(noteDouble, myComment2)
    NoteService.edit(1, "Edit Title", "Edit Text")

    NoteService.getNote()
    println()
    NoteService.deleteComment(noteDouble, 3)
    NoteService.getNoteById(1)
    NoteService.getComments(noteOne)
    NoteService.delete(1)
    NoteService.getNote()
    NoteService.restoreComment(noteDouble, 3)
    NoteService.editComment(noteDouble,2,"Edit Message")
    NoteService.getNote()


}
