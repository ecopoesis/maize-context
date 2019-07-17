package com.indigoag.maizecontext

import com.expedia.graphql.SchemaGeneratorConfig
import com.expedia.graphql.TopLevelObject
import com.expedia.graphql.extensions.print
import com.expedia.graphql.toSchema
import com.indigoag.maizecontext.query.Query
import graphql.GraphQL
import graphql.schema.GraphQLSchema
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class MaizeContextApplication {

	private val logger = LoggerFactory.getLogger(MaizeContextApplication::class.java)

	@Bean
	fun schemaConfig(): SchemaGeneratorConfig = SchemaGeneratorConfig(listOf("com.indigoag"))

	@Bean
	fun schema(
			queries: List<Query>,
			schemaConfig: SchemaGeneratorConfig
	): GraphQLSchema {
		fun List<Any>.toTopLevelObjects() = this.map {
			TopLevelObject(it)
		}

		val schema = toSchema(
				config = schemaConfig,
				queries = queries.toTopLevelObjects()
		)

		logger.info(schema.print())

		return schema
	}

	@Bean
	fun graphQL(schema: GraphQLSchema): GraphQL = GraphQL.newGraphQL(schema).build()
}

fun main(args: Array<String>) {
	runApplication<MaizeContextApplication>(*args)
}
