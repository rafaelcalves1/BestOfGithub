package com.rafa.bestofgithub.data.repository

import androidx.paging.PagingData
import com.rafa.bestofgithub.commons.Constants
import com.rafa.bestofgithub.data.db.GitRepositoryDao
import com.rafa.bestofgithub.data.remote.dto.toItems
import com.rafa.bestofgithub.data.remote.service.GithubApi
import com.rafa.bestofgithub.domain.model.Items
import com.rafa.bestofgithub.domain.repository.GitHubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class GitHubRemoteRepositoryImpl @Inject constructor(
    private val dao: GitRepositoryDao,
    private val apiService: GithubApi
) : GitHubRepository {

    override suspend fun pegaRepository(page: Int): Flow<PagingData<List<Items>>> {
        apiService.getRepositorys(
            Constants.SEARCH_KEYWORD,
            sort = Constants.SORT_STARS,
            Constants.ORDER_DESC,
            Constants.PER_PAGE,
            page = page
        ).collect { response ->
            dao.adicionaItems(response.items.map {
                it.toItems()
            })
        }
        return dao.pegaItems(page)
    }

}