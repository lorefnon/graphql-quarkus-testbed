package com.example.resource

import com.example.entity.Notebook
import io.smallrye.graphql.api.Nullable
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query
import org.eclipse.microprofile.graphql.Source
import org.hibernate.reactive.mutiny.Mutiny

@GraphQLApi
class NotebookResource {
    @Query
    @Nullable // Without specifying this explicitly it is treated as nullable
    fun notebookById(id: Long) =
        Notebook.find("id", id).firstResult()

    @Query
    fun author(@Source notebook: Notebook) =
        Mutiny.fetch(notebook.creator)
}