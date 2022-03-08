package com.rafa.bestofgithub.data.repository.data_source

import com.rafa.bestofgithub.domain.model.Items
import kotlinx.coroutines.flow.Flow

interface GithubLocalDataSource {

    fun pegaRepositoriosDb(): Flow<List<Items>>
}