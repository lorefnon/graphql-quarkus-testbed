package com.example.entity

import io.quarkus.hibernate.reactive.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.reactive.panache.kotlin.PanacheEntity
import javax.persistence.*

@Entity
@Table(name = "notebook")
class Notebook: PanacheEntity() {
    lateinit var title: String
    lateinit var description: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id")
    lateinit var creator: AppUser

    companion object: PanacheCompanion<Notebook>
}