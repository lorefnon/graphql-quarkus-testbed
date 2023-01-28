package com.example.resource

import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class TestResource {

    @Query
    fun test() = "Test"
}