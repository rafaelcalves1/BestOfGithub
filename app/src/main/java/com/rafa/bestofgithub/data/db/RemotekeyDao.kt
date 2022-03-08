package com.rafa.bestofgithub.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rafa.bestofgithub.domain.model.RemoteKey

@Dao
interface RemotekeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun adicionaKeys(remoteKey: List<RemoteKey>)

    @Query("SELECT * FROM remotekey WHERE id= :id")
    suspend fun pegaKeyById(id: String): RemoteKey?

    @Query("DELETE FROM remotekey")
    suspend fun deletaKeys()
}