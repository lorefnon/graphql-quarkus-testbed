package com.example.repository

import com.example.dal.generated.jooq.tables.daos.NotebookDao
import org.jooq.DSLContext
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class NotebookRepo(jooqCtx: DSLContext): NotebookDao(jooqCtx.configuration()) {

}