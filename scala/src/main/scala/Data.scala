case class Book(
  id: String,
  name: String,
  pageCount: Int,
  authorId: String
)

case class Author(
  id: String,
  firstName: String,
  lastName: String
)

class Context {
  import Context._

  def getBook(id: String): Option[Book] = books.find(c => c.id == id)
  def getAuthor(id: String): Option[Author] = authors.find(c => c.id == id)
}

object Context {
  val books = List(
    Book(
      id = "book-1",
      name = "Harry Potter and the Philosopher's Stone",
      pageCount = 223,
      authorId = "author-1"
    ),
    Book(
      id = "book-2",
      name = "Moby Dick",
      pageCount = 635,
      authorId = "author-2"
    )
  )

  val authors = List(
    Author(
      id = "author-1",
      firstName = "Joanne",
      lastName = "Rowling"),
    Author(
      id = "author-2",
      firstName = "Herman",
      lastName = "Melville"),
  )
}
