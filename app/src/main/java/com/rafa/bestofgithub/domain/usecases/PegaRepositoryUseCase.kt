package com.rafa.bestofgithub.domain.usecases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rafa.bestofgithub.commons.Constants
import com.rafa.bestofgithub.data.db.GitRepositoryDao
import com.rafa.bestofgithub.domain.model.Items
import com.rafa.bestofgithub.domain.repository.GitHubRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PegaRepositoryUseCase @Inject constructor(
    private val repository: GitHubRepository
) {

    operator fun invoke(): Flow<PagingData<Items>>{
        return repository.pegaRepositorios()
    }

}