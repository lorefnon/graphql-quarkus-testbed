package com.example.resource

import com.example.dal.generated.jooq.tables.pojos.AppUser
import com.example.dal.generated.jooq.tables.pojos.Notebook
import com.example.repository.NotebookRepo
import io.smallrye.graphql.api.Nullable
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query
import org.eclipse.microprofile.graphql.Source
import javax.inject.Inject

@GraphQLApi
class NotebookResource {
    @Query
    @Nullable // Without specifying this explicitly it is treated as non-nullable
    fun notebookById(id: Int): Notebook? =
        notebookRepo.findById(id)

    @Query
    fun notebooks(
        @Source appUsers: List<AppUser>
    ): List<Notebook> =
        notebookRepo.findAllByCreatorIds(appUsers.map { it.id })

    @Inject
    internal lateinit var notebookRepo: NotebookRepo
}

class NotebookInput {
    lateinit var title: String
    var description: String? = null
}