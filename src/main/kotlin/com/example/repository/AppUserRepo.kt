package com.example.repository

import com.example.dal.generated.jooq.tables.daos.AppUserDao
import org.jooq.DSLContext
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class AppUserRepo(jooqCtx: DSLContext): AppUserDao(jooqCtx.configuration()) {

}