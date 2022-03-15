package com.rafa.bestofgithub.data.remote.service

import com.rafa.bestofgithub.commons.Constants
import com.rafa.bestofgithub.commons.Resposta
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories")
    suspend fun getRepositorys(
        @Query (value = "q") q: String = Constants.SEARCH_KEYWORD,
        @Query (value = "sort") sort: String = Constants.SORT_STARS,
        @Query (value = "order") order: String = Constants.ORDER_DESC,
        @Query (value = "per_page") perPage: Int,
        @Query (value = "page") page: Int = 1
    ): retrofit2.Response<Resposta>
}