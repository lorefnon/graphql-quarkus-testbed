package com.example.util

import org.jooq.codegen.GenerationTool
import org.jooq.meta.jaxb.*
import org.jooq.meta.jaxb.Target
import java.io.FileInputStream
import java.util.Properties

fun main(args: Array<String>) {
    val props = Properties()
    props.load(FileInputStream("src/main/resources/application.properties"))

    GenerationTool.generate(
        Configuration()
            .withJdbc(
                Jdbc()
                    .withDriver("org.postgresql.Driver")
                    .withUrl(props["quarkus.datasource.jdbc.url"].toString())
                    .withUser(props["quarkus.datasource.username"].toString())
                    .withPassword(props["quarkus.datasource.password"].toString())
            )
            .withGenerator(
                Generator()
                    .withName("org.jooq.codegen.JavaGenerator")
                    .withDatabase(Database()
                        .withInputSchema("public")
                        .withExcludes("DATABASECHANGELOG"))
                    .withGenerate(
                        Generate()
                            .withPojos(true)
                            .withDaos(true)
                            .withRecords(false)
                    )
                    .withTarget(
                        Target()
                            .withPackageName("com.example.dal.generated.jooq")
                            .withDirectory("src/main/java")
                    )
            )
    )
}