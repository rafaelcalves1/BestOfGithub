package com.rafa.bestofgithub.domain.repository

import androidx.paging.PagingData
import com.rafa.bestofgithub.commons.Response
import com.rafa.bestofgithub.domain.model.Items
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {

    suspend fun pegaRepository(page: Int): Flow<PagingData<List<Items>>>

}