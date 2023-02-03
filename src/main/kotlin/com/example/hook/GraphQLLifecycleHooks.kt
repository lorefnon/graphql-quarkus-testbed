package com.example.hook

/*
import com.example.repository.NotebookRepo
import graphql.GraphQL
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentation
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentationOptions
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes

@ApplicationScoped
class GraphQLLifecycleHooks(
    private val notebookRepo: NotebookRepo
) {
    fun injectInterceptors(
        @Observes graphql: GraphQL.Builder
    ) {
        graphql.instrumentation(DataLoaderDispatcherInstrumentation(
            DataLoaderDispatcherInstrumentationOptions
                .newOptions()
                .includeStatistics(true)
        ))
    }
} */