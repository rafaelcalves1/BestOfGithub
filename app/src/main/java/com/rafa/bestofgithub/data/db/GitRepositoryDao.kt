package com.rafa.bestofgithub.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.rafa.bestofgithub.domain.model.Items
import kotlinx.coroutines.flow.Flow

@Dao
interface GitRepositoryDao {

    @Query("SELECT * FROM items ORDER BY qtdEstrelas DESC  LIMIT 100 OFFSET :page")
    suspend fun pegaItems(page: Int): Flow<List<Items>>

    @Insert(onConflict = REPLACE)
    suspend fun adicionaItems(items: Items)

}