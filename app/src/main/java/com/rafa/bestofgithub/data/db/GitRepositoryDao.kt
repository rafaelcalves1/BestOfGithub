package com.rafa.bestofgithub.data.db

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.rafa.bestofgithub.domain.model.Items
import kotlinx.coroutines.flow.Flow

@Dao
interface GitRepositoryDao {

    @Query("SELECT * FROM items ORDER BY qtdEstrelas DESC")
    fun pegaItems(): PagingSource<Int, List<Items>>

    @Insert(onConflict = REPLACE)
    suspend fun adicionaItems(items: List<Items>)

    @Query("SELECT * FROM items WHERE id= :itemId")
    fun pegaItem(itemId: Int): Flow<Items>

}