package com.example.entity

import io.quarkus.hibernate.reactive.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.reactive.panache.kotlin.PanacheEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "app_user")
class AppUser: PanacheEntity() {
    lateinit var name: String

    companion object: PanacheCompanion<AppUser> {
        fun findByName(name: String) = find("name", name).firstResult()
    }
}