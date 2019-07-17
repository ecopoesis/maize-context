package com.indigoag.maizecontext.query

import com.expedia.graphql.annotations.GraphQLID
import com.indigoag.maizecontext.Data
import org.springframework.stereotype.Component

@Component
class Query {
    data class BookType(
            @GraphQLID val id: String,
            val name: String,
            val pageCount: Int,
            val author: AuthorType?
    )

    data class AuthorType(
            @GraphQLID val id: String,
            val firstName: String,
            val lastName: String
    )

    fun book(@GraphQLID id: String): BookType? {
        return Data.books.find { b -> b.id == id }?.let { b->
            BookType(
                    id = b.id,
                    name = b.name,
                    pageCount = b.pageCount,
                    author = Data.authors.find { a -> a.id == b.authorId }?.let { a->
                        AuthorType(
                                id = a.id,
                                firstName = a.firstName,
                                lastName = a.lastName
                        )
                    }
            )
        }
    }
}

