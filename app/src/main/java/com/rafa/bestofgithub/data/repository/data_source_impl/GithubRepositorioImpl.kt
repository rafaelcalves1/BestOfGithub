package com.rafa.bestofgithub.data.repository.data_source_impl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rafa.bestofgithub.commons.Constants
import com.rafa.bestofgithub.data.db.GitRepositoryDao
import com.rafa.bestofgithub.data.paging.RepositorioRemotoMediator
import com.rafa.bestofgithub.data.remote.service.GithubApi
import com.rafa.bestofgithub.data.repository.data_source.GithubRemoteDataSource
import com.rafa.bestofgithub.domain.model.Items
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GithubRepositorioImpl @Inject constructor(
    private val dao: GitRepositoryDao,
    private val apiService: GithubApi
): GithubRemoteDataSource{


    override fun pegaRepositorios(): Flow<PagingData<Items>> {
        val pagingFactory = { dao.pegaItems() }
        return Pager(
            config = PagingConfig(pageSize = Constants.PER_PAGE),
            remoteMediator = RepositorioRemotoMediator(

            )
        )
    }


}