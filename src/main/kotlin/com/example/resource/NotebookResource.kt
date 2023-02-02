package com.example.resource

import com.example.dal.generated.jooq.tables.daos.AppUserDao
import com.example.dal.generated.jooq.tables.daos.NotebookDao
import com.example.dal.generated.jooq.tables.pojos.Notebook
import com.example.repository.AppUserRepo
import com.example.repository.NotebookRepo
import io.smallrye.graphql.api.Nullable
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query
import org.eclipse.microprofile.graphql.Source
import javax.inject.Inject

@GraphQLApi
class NotebookResource(
    private val appUserRepo: AppUserRepo,
    private val notebookRepo: NotebookRepo
) {
    @Query
    @Nullable // Without specifying this explicitly it is treated as non-nullable
    fun notebookById(id: Int) =
        notebookRepo.findById(id)

    @Query
    fun author(@Source notebook: Notebook) =
        if (notebook.creatorId == null) null
        else appUserRepo.findById(notebook.creatorId)
}

class NotebookInput {
    lateinit var title: String
    var description: String? = null
}