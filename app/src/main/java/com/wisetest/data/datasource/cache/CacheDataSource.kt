package com.wisetest.data.datasource.cache

import com.wisetest.data.cache.AppDatabase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class CacheDataSource @Inject constructor(
    val appDatabase: AppDatabase,
    val coroutineDispatcher: CoroutineDispatcher
    ){


    }