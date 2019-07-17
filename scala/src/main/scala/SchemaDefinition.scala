import sangria.schema._

object SchemaDefinition {
  val AuthorType =
    ObjectType(
      "Author",
      fields[Context, Author](
        Field("id", IDType, resolve = _.value.id),
        Field("firstName", StringType, resolve = _.value.firstName),
        Field("lastName", StringType, resolve = _.value.lastName)
      ))

  val BookType =
    ObjectType(
      "Book",
      fields[Context, Book](
        Field("id", IDType, resolve = _.value.id),
        Field("name", StringType, resolve = _.value.name),
        Field("pageCount", IntType, resolve = _.value.pageCount),
        Field("author", OptionType(AuthorType), resolve = c => Context.authors.find(a => a.id == c.value.authorId))
      ))

  val IdArg = Argument("id", IDType)

  val Query = ObjectType(
    "Query", fields[Context, Unit](
      Field("book", OptionType(BookType),
        arguments = IdArg :: Nil,
        resolve = ctx => ctx.ctx.getBook(ctx.arg(IdArg))),
    ))

  val BooksSchema = Schema(Query)
}
