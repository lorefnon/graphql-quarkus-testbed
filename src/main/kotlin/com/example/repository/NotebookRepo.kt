package com.example.repository

import com.example.dal.generated.jooq.tables.daos.NotebookDao
import com.example.dal.generated.jooq.tables.pojos.Notebook
import com.example.dal.generated.jooq.tables.records.NotebookRecord
import org.jooq.DSLContext
import org.jooq.ResultQuery
import javax.enterprise.context.ApplicationScoped
import com.example.dal.generated.jooq.Tables as T

@ApplicationScoped
class NotebookRepo(
    private val jooqCtx: DSLContext
) : NotebookDao(jooqCtx.configuration()) {

    fun findAllByCreatorIds(creatorIds: List<Int>) =
        fromNotebook()
            .where(T.NOTEBOOK.CREATOR_ID.`in`(creatorIds))
            .intoNotebook()

    fun findAllByIds(ids: List<Int>) =
        fromNotebook()
            .where(T.NOTEBOOK.ID.`in`(ids))
            .intoNotebook()

    fun fromNotebook() =
        jooqCtx.selectFrom(T.NOTEBOOK)

    fun ResultQuery<NotebookRecord>.intoNotebook(): List<Notebook> =
        fetchInto(Notebook::class.java)
}
