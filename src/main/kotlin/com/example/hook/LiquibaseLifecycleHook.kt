package com.example.hook

import io.quarkus.runtime.StartupEvent
import liquibase.Liquibase
import liquibase.database.DatabaseFactory
import liquibase.resource.ClassLoaderResourceAccessor
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.jboss.logging.Logger
import java.lang.Exception
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes
import javax.inject.Inject

@ApplicationScoped
class LiquibaseLifecycleHook {
    @Inject
    internal lateinit var log: Logger

    @ConfigProperty(name = "quarkus.datasource.username")
    internal lateinit var dbUsername: String

    @ConfigProperty(name = "quarkus.datasource.password")
    internal lateinit var dbPassword: String

    @ConfigProperty(name = "quarkus.datasource.jdbc.url")
    internal lateinit var jdbcUrl: String

    @ConfigProperty(name = "quarkus.liquibase.change-log")
    internal lateinit var changelogLocation: String

    fun onStart(@Observes ev: StartupEvent) {
        upgradeLiquibaseSchema()
    }

    private fun upgradeLiquibaseSchema() {
        log.info("Running liquibase migrations")
        var liquibase: Liquibase? = null
        try {
            val resourceAccessor = ClassLoaderResourceAccessor(Thread.currentThread().contextClassLoader)
            val conn = DatabaseFactory.getInstance().openConnection(
                jdbcUrl,
                dbUsername,
                dbPassword,
                null,
                resourceAccessor
            )
            liquibase = Liquibase(
                changelogLocation,
                resourceAccessor,
                conn
            )
            liquibase.update()
            log.info("Successfully updated")
        } catch (e: Exception) {
            log.error("Liquibase migration exception", e)
        } finally {
            liquibase?.close()
        }
    }
}