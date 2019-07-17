package com.indigoag.maizecontext

class Data {
    companion object {
        val books = listOf(
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

        val authors = listOf(
                Author(
                        id = "author-1",
                        firstName = "Joanne",
                        lastName = "Rowling"),
                Author(
                        id = "author-2",
                        firstName = "Herman",
                        lastName = "Melville")
        )

    }

    data class Book(
            val id: String,
            val name: String,
            val pageCount: Int,
            val authorId: String
    )

    data class Author(
            val id: String,
            val firstName: String,
            val lastName: String
    )
}
