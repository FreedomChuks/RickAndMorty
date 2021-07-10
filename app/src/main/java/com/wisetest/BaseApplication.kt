package com.wisetest

import android.app.Application
import com.rommansabbir.networkx.core.NetworkXCore
import com.rommansabbir.networkx.strategy.NetworkXObservingStrategy
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree

@HiltAndroidApp
class BaseApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
        NetworkXCore.init(this, NetworkXObservingStrategy.HIGH)
    }
}