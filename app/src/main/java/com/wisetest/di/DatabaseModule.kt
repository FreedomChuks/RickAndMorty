package com.wisetest.di

import android.app.Application
import androidx.room.Room
import com.wisetest.data.cache.AppDatabase
import com.wisetest.data.cache.dao.CharacterDao
import com.wisetest.utils.Constant.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Singleton
    @Provides
    fun providesAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesCharacterDao(appDatabase: AppDatabase): CharacterDao {
        return appDatabase.CharacterDao()
    }
}