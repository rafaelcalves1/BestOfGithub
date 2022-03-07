package com.rafa.bestofgithub.domain.model

data class Items(
    val nomeRepo: String? = null,
    val qtdEstrelas: Int? = 0,
    val qtdFork: Int? = 0,
    val owner: Owner
)
