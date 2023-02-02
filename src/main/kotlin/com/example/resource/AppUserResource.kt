package com.example.resource

import com.example.repository.AppUserRepo
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query
import javax.inject.Inject

@GraphQLApi
class AppUserResource(
    private val appUserRepo: AppUserRepo
) {
    @Query
    fun appUserByName(name: String) =
        appUserRepo.fetchByName(name).firstOrNull()
}