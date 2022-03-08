package com.rafa.bestofgithub.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Items(
    val nomeRepo: String? = null,
    val qtdEstrelas: Int? = 0,
    val qtdFork: Int? = 0,
    val nomeOwner: String? = null,
    val avatarOwner: String? = null,
    @PrimaryKey val id: Int
)
