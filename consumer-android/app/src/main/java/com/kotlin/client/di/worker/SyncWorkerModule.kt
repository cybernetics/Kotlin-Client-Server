package com.kotlin.client.di.worker

import com.kotlin.client.domain.SyncTradesImpl
import com.kotlin.core.repository.SyncRepository
import com.kotlin.core.usecases.SyncTrades
import dagger.Module
import dagger.Provides

@Module
class SyncWorkerModule {
    @Provides
    fun providesWorkerFactory(syncTrades: SyncTrades)
            : DaggerWorkerFactory = DaggerWorkerFactory(syncTrades)

    @Provides
    fun provideSyncTrades(repository: SyncRepository): SyncTrades =
            SyncTradesImpl(repository)
}