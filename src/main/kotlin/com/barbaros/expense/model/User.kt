package com.barbaros.expense.model

import jakarta.persistence.*

@Entity
@Table(name ="users")
data class User(
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true, nullable =false)
    val email: String,

    @Column(nullable = false)
    val password: String
) {
    constructor() : this(null, "", "") {

    }
}
