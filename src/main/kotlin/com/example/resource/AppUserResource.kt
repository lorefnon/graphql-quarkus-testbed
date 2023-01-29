package com.example.resource

import com.example.dal.generated.jooq.tables.daos.AppUserDao
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query
import javax.inject.Inject

@GraphQLApi
class AppUserResource {
    @Inject
    internal lateinit var appUserDao: AppUserDao

    @Query
    fun appUserByName(name: String) =
        appUserDao.fetchByName(name).firstOrNull()
}