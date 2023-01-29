package com.example.dal

import com.example.dal.generated.jooq.tables.daos.AppUserDao
import com.example.dal.generated.jooq.tables.daos.NotebookDao
import org.jooq.DSLContext
import javax.enterprise.inject.Produces
import javax.inject.Inject

class DAOFactory {
    @Inject
    internal lateinit var context: DSLContext

    @Produces
    fun getAppUserDao() = AppUserDao(context.configuration())

    @Produces
    fun getNotebookDao() = NotebookDao(context.configuration())
}