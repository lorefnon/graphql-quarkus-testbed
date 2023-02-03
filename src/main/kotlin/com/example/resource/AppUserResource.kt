package com.example.resource

import com.example.dal.generated.jooq.tables.pojos.Notebook
import com.example.repository.AppUserRepo
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query
import org.eclipse.microprofile.graphql.Source
import javax.inject.Inject

@GraphQLApi
class AppUserResource {
    @Query
    fun appUserByName(name: String) =
        appUserRepo.findByName(name)

    @Query
    fun appUsersByNames(names: List<String>) =
        appUserRepo.findAllByNames(names)

    @Query
    fun notebookAuthor(
        @Source notebook: Notebook
    ) =
        if (notebook.creatorId == null) null
        else appUserRepo.findById(notebook.creatorId)

    @Inject
    lateinit var appUserRepo: AppUserRepo
}