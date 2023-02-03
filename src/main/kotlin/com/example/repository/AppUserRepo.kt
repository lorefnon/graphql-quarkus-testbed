package com.example.repository

import com.example.dal.generated.jooq.Tables as T
import com.example.dal.generated.jooq.tables.daos.AppUserDao
import com.example.dal.generated.jooq.tables.pojos.AppUser
import org.jooq.DSLContext
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class AppUserRepo(private val jooqCtx: DSLContext): AppUserDao(jooqCtx.configuration()) {
    fun findByName(name: String) =
        fetchByName(name).firstOrNull()

    fun findAllByNames(names: List<String>): List<AppUser> =
        jooqCtx
            .selectFrom(T.APP_USER)
            .where(T.APP_USER.NAME.`in`(names))
            .fetchInto(AppUser::class.java)
}