package com.rafa.bestofgithub.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rafa.bestofgithub.domain.model.Items
import com.rafa.bestofgithub.domain.model.RemoteKey

@Database(
    entities = [Items::class, RemoteKey::class],
    version = 1
)
abstract class GitRepositoryDataBase: RoomDatabase() {

    abstract fun gitRepositoryDao(): GitRepositoryDao
    abstract fun remoteKeyDao(): RemotekeyDao

    companion object{
        const val DATABASE_NAME = "remote_key_db"
    }
}