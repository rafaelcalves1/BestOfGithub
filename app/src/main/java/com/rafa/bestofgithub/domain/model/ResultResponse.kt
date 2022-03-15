package com.rafa.bestofgithub.domain.model

data class ResultResponse(
    val remoteKeys: List<RemoteKey> = emptyList(),
    val items: List<Items> = emptyList()
)
