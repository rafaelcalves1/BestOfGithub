package com.rafa.bestofgithub

import android.app.Application
import androidx.room.Room
import com.rafa.bestofgithub.data.db.GitRepositoryDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        var itemsDatabase: GitRepositoryDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        itemsDatabase = Room.databaseBuilder(this, GitRepositoryDataBase::class.java, GitRepositoryDataBase.DATABASE_NAME).allowMainThreadQueries()
            .build()
    }
}