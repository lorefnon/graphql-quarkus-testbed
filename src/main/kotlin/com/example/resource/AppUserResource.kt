package com.example.resource

import com.example.entity.AppUser
import org.eclipse.microprofile.graphql.Description
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class AppUserResource {

    @Query
    @Description("Say hello")
    fun appUserByName(name: String) =
        AppUser.findByName(name)
}