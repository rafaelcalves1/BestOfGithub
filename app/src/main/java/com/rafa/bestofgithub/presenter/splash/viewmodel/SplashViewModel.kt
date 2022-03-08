package com.rafa.bestofgithub.presenter.splash.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.rafa.bestofgithub.domain.model.Items
import com.rafa.bestofgithub.domain.usecases.PegaRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SplashViewModel  @Inject constructor(
    private val pegaRepositoryUseCase: PegaRepositoryUseCase
): ViewModel(){

    fun pegaRepository(): Flow<PagingData<Items>>{
        return pegaRepositoryUseCase()
    }
}