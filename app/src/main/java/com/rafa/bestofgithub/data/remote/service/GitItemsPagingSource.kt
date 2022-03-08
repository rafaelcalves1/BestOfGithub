package com.rafa.bestofgithub.data.remote.service

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rafa.bestofgithub.data.remote.dto.toItems
import com.rafa.bestofgithub.domain.model.Items
import javax.inject.Inject

private const val PAGE_START = 1

class GitItemsPagingSource @Inject constructor(
    private val service: GithubApi
) : PagingSource<Int, Items>() {

    override fun getRefreshKey(state: PagingState<Int, Items>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition = anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition = anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Items> {
        val page = params.key ?: PAGE_START
        return try {
            val response = service.getRepositorys(page = PAGE_START, perPage = params.loadSize)
            if (!response.isSuccessful)
                return LoadResult.Error(Throwable(response.message()))
            val items = response.body()?.items?.map { it.toItems() }
            LoadResult.Page(
                data = items ?: emptyList(),
                prevKey = if (page == PAGE_START) null else page - 1,
                nextKey = if (items?.isEmpty() != false) null else page + 1
            )
        } catch (e: Throwable) {
            return LoadResult.Error(e)
        }
    }
}