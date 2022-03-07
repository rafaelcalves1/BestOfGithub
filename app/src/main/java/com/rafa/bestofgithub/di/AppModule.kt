package com.rafa.bestofgithub.di

import android.app.Application
import androidx.room.Room
import androidx.viewbinding.BuildConfig
import com.rafa.bestofgithub.commons.Constants
import com.rafa.bestofgithub.data.db.GitRepositoryDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesDataBase(application: Application): GitRepositoryDataBase{
        return Room.databaseBuilder(application, GitRepositoryDataBase::class.java, GitRepositoryDataBase.DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client())
            .build()
    }

    private fun client(): OkHttpClient {
        val client = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            client.addInterceptor(interceptor)
        }
        return client.build()
    }
}