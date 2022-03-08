package com.rafa.bestofgithub.presenter.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.rafa.bestofgithub.domain.model.Items
import com.rafa.bestofgithub.domain.usecases.PegaRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pegaRepositoryUseCase: PegaRepositoryUseCase
): ViewModel(){

    fun pegaRepository(): Flow<PagingData<Items>> {
        return pegaRepositoryUseCase().cachedIn(viewModelScope)
    }
}