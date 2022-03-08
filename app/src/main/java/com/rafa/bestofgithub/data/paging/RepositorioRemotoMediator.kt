package com.rafa.bestofgithub.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.rafa.bestofgithub.data.db.GitRepositoryDao
import com.rafa.bestofgithub.data.db.GitRepositoryDataBase
import com.rafa.bestofgithub.data.remote.service.GithubApi
import com.rafa.bestofgithub.domain.model.Items
import java.lang.Exception
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class RepositorioRemotoMediator @Inject constructor(
    private val  githubApi: GithubApi,
    private val githubDB: GitRepositoryDataBase
): RemoteMediator<Int, Items>() {

    private val dao = githubDB.gitRepository

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Items>): MediatorResult {
        return try {
            val page = when (loadType){
                LoadType.REFRESH -> {
                   val keys =
                }
            }
        }catch (e: Exception){
            return MediatorResult.Error(e)
        }
    }

    private suspend fun pegaAtualPagRemota(
        state: PagingState<Int, Items>
    ): Int?{
        return  state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id.let { id ->
                dao.pegaItem(id)
            }
        }
    }
}