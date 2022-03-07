package com.rafa.bestofgithub.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rafa.bestofgithub.domain.model.Items

@Database(
    entities = [Items::class],
    version = 1
)
abstract class GitRepositoryDataBase: RoomDatabase() {

    abstract val gitRepository: GitRepositoryDao

    companion object{
        const val DATABASE_NAME = "items_db"
    }
}