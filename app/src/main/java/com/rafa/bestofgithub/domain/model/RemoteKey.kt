package com.rafa.bestofgithub.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RemoteKey(
    @PrimaryKey val id: String,
    val prevKey: Int?,
    val nextKey: Int?
)
