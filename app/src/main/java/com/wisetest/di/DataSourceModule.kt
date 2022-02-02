package com.wisetest.di

import com.wisetest.data.cache.dao.CharacterDao
import com.wisetest.data.datasource.cache.CacheDataSource
import com.wisetest.data.datasource.network.NetworkDataSource
import com.wisetest.data.network.ApiService
import com.wisetest.data.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Provides
    @Singleton
    fun provideCacheDataSource(dbSource: CharacterDao)=CacheDataSource(
        dbSource
    )

    @Provides
    @Singleton
    fun provideNetworkDataSource(apiService: ApiService)=NetworkDataSource(
        apiService
    )

    @Provides
    @Singleton
    fun provideCharacterRepo(apiService: NetworkDataSource,dataSource: CacheDataSource)=
        CharacterRepository(apiService,dataSource)

}