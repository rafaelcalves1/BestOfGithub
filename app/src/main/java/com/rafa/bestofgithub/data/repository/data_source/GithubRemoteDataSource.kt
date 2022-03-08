package com.rafa.bestofgithub.data.repository.data_source

import androidx.paging.PagingData
import com.rafa.bestofgithub.domain.model.Items
import kotlinx.coroutines.flow.Flow

interface GithubRemoteDataSource {

    fun pegaRepositorios(): Flow<PagingData<Items>>
}