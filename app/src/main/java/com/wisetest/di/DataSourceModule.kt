package com.wisetest.di

import com.wisetest.data.cache.AppDatabase
import com.wisetest.data.datasource.CharacterDataSource
import com.wisetest.data.network.ApiService
import com.wisetest.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DataSourceModule {

    @Provides
    @Singleton
    fun getDataSource(apiService: ApiService,dbSource: AppDatabase)=CharacterDataSource(
        apiService,dbSource
    )

    @Provides
    @Singleton
    fun provideCharacterRepo(dataSource: CharacterDataSource)=Repository(dataSource)

}