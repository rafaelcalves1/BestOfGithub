package com.rafa.bestofgithub.domain.repository

import androidx.paging.PagingData
import com.rafa.bestofgithub.commons.Response
import com.rafa.bestofgithub.domain.model.Items
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {

    fun pegaRepositorios(): Flow<PagingData<Items>>

}