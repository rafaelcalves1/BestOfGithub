package com.rafa.bestofgithub.domain.usecases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rafa.bestofgithub.commons.Constants
import com.rafa.bestofgithub.data.db.GitRepositoryDao
import com.rafa.bestofgithub.domain.model.Items
import kotlinx.coroutines.flow.Flow

class PegaRepositoryUseCase(
    private val dao: GitRepositoryDao,
) {

    suspend operator fun invoke(): Flow<PagingData<Items>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.PER_PAGE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                GitItemsPagingSource(dao)
            }
        ).flow
    }
}