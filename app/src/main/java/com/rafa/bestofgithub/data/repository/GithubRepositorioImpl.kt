package com.rafa.bestofgithub.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rafa.bestofgithub.data.db.GitRepositoryDataBase
import com.rafa.bestofgithub.data.paging.RepositorioRemotoMediator
import com.rafa.bestofgithub.data.remote.service.GithubApi
import com.rafa.bestofgithub.domain.model.Items
import com.rafa.bestofgithub.domain.repository.GitHubRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

private const val PAGE_SIZE = 30

@Singleton
class GithubRepositorioImpl(
    private val dataBase: GitRepositoryDataBase,
    private val apiService: GithubApi
) : GitHubRepository {


    @OptIn(ExperimentalPagingApi::class)
    override fun pegaRepositorios(): Flow<PagingData<Items>> {
        val pagingFactory = { dataBase.gitRepositoryDao().pegaItems() }
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                maxSize = PagingConfig.MAX_SIZE_UNBOUNDED,
                enablePlaceholders = false,
            ),
            remoteMediator = RepositorioRemotoMediator(
                githubApi = apiService,
                githubDB = dataBase
            ),
            pagingSourceFactory = pagingFactory
        ).flow
    }


}