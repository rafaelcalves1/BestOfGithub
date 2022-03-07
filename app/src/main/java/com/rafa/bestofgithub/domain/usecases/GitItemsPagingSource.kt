package com.rafa.bestofgithub.domain.usecases

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rafa.bestofgithub.data.db.GitRepositoryDao
import com.rafa.bestofgithub.domain.model.Items
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

private const val PAGE_START = 1
private const val LIST_ITEMS_SIZE = 100

class GitItemsPagingSource @Inject constructor(
    private val service: GitRepositoryDao
) : PagingSource<Int, Items>() {

    override fun getRefreshKey(state: PagingState<Int, Items>): Int? {
        return state.anchorPosition?.let{ anchorPosition ->
            state.closestPageToPosition(anchorPosition = anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition = anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Items> {
        val pageIndex = params.key ?: PAGE_START
       return try {
           val response: ArrayList<Items> = arrayListOf()
            service.pegaItems(page = pageIndex).collect {
               response.addAll(it)
            }
           val nextKey = if(response.isEmpty()) null else pageIndex + (params.loadSize / LIST_ITEMS_SIZE)
           LoadResult.Page(
               data = response,
               prevKey = if (pageIndex == PAGE_START) null else pageIndex,
               nextKey = nextKey
           )
        }catch (e: Throwable){
            return LoadResult.Error(e)
        }
    }
}