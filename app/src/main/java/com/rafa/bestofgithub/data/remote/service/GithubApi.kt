package com.rafa.bestofgithub.data.remote.service

import com.rafa.bestofgithub.commons.Response
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories")
    suspend fun getRepositorys(
        @Query (value = "q") q: String,
        @Query (value = "sort") sort: String,
        @Query (value = "order") order: String,
        @Query (value = "per_page") perPage: Int,
        @Query (value = "page") page: Int = 1
    ): retrofit2.Response<Response>
}