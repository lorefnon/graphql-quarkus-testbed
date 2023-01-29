/*
 * This file is generated by jOOQ.
 */
package com.example.dal.generated.jooq


import com.example.dal.generated.jooq.tables.AppUser
import com.example.dal.generated.jooq.tables.Databasechangeloglock
import com.example.dal.generated.jooq.tables.Notebook

import kotlin.collections.List

import org.jooq.Catalog
import org.jooq.Table
import org.jooq.impl.SchemaImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Public : SchemaImpl("public", DefaultCatalog.DEFAULT_CATALOG) {
    public companion object {

        /**
         * The reference instance of <code>public</code>
         */
        val PUBLIC: Public = Public()
    }

    /**
     * The table <code>public.app_user</code>.
     */
    val APP_USER: AppUser get() = AppUser.APP_USER

    /**
     * The table <code>public.databasechangeloglock</code>.
     */
    val DATABASECHANGELOGLOCK: Databasechangeloglock get() = Databasechangeloglock.DATABASECHANGELOGLOCK

    /**
     * The table <code>public.notebook</code>.
     */
    val NOTEBOOK: Notebook get() = Notebook.NOTEBOOK

    override fun getCatalog(): Catalog = DefaultCatalog.DEFAULT_CATALOG

    override fun getTables(): List<Table<*>> = listOf(
        AppUser.APP_USER,
        Databasechangeloglock.DATABASECHANGELOGLOCK,
        Notebook.NOTEBOOK
    )
}