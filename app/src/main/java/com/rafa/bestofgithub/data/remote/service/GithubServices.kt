package com.rafa.bestofgithub.data.remote.service

import com.rafa.bestofgithub.commons.Constants
import com.rafa.bestofgithub.commons.Response
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubServices @Inject constructor(
    retrofit: Retrofit
): GithubApi {
    private val gitApi by lazy { retrofit.create(GithubApi::class.java) }

    override suspend fun getRepositorys(
        q: String,
        sort: String,
        order: String,
        perPage: Int,
        page: Int
    ): Flow<Response>  = gitApi.getRepositorys(q = Constants.SEARCH_KEYWORD, sort = Constants.SORT_STARS, order = Constants.ORDER_DESC, Constants.PER_PAGE, page)
}