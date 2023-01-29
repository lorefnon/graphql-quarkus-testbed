package com.example.resource

import com.example.dal.generated.jooq.tables.daos.AppUserDao
import com.example.dal.generated.jooq.tables.daos.NotebookDao
import com.example.dal.generated.jooq.tables.pojos.Notebook
import io.smallrye.graphql.api.Nullable
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query
import org.eclipse.microprofile.graphql.Source
import javax.inject.Inject

@GraphQLApi
class NotebookResource {
    @Query
    @Nullable // Without specifying this explicitly it is treated as nullable
    fun notebookById(id: Int) =
        notebookDao.findById(id)

    @Query
    fun author(@Source notebook: Notebook) =
        if (notebook.creatorId == null) null
        else usersDao.findById(notebook.creatorId)

    @Inject
    internal lateinit var notebookDao: NotebookDao

    @Inject
    internal lateinit var usersDao: AppUserDao
}

class NotebookInput {
    lateinit var title: String
    var description: String? = null
}