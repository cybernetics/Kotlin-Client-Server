package com.kotlin.server.repository.di

import com.googlecode.objectify.Objectify
import com.googlecode.objectify.ObjectifyService

import com.googlecode.objectify.Ref
import com.kotlin.core.repository.PairsRepository
import com.kotlin.core.repository.SyncRepository
import com.kotlin.core.repository.TradesRepository
import com.kotlin.server.repository.GetTradesRepositoryImpl
import com.kotlin.server.repository.PairRepositoryImpl
import com.kotlin.server.repository.SyncPairsRepositoryImpl
import com.kotlin.server.repository.api.BxApi
import com.kotlin.server.repository.database.PairStore
import com.kotlin.server.repository.database.SymbolStore
import com.kotlin.server.repository.database.TradeStore
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    init {
        initData()
    }

    @Provides
    fun providesTradesRepository(objectify: Objectify,
                                 api: BxApi): TradesRepository = GetTradesRepositoryImpl(objectify, api)

    @Provides
    fun providesPairRepository(objectify: Objectify,
                               api: BxApi): PairsRepository = PairRepositoryImpl(objectify)

    @Provides
    fun providesSyncPairRepository(objectify: Objectify,
                                   api: BxApi) = SyncPairsRepositoryImpl(objectify, api)

    @Provides
    fun providesSyncRepository(objectify: Objectify,
                               api: BxApi): SyncRepository = SyncPairsRepositoryImpl(objectify, api)

    @Provides
    fun providesRestApi(): BxApi = BxApi()

    @Provides
    fun providesObjectifyService(): Objectify {
        return ObjectifyService.ofy()
    }

    private fun initData() {
        ObjectifyService.begin()
        ObjectifyService.register(TradeStore::class.java)
        ObjectifyService.register(PairStore::class.java)
        ObjectifyService.register(SymbolStore::class.java)

        ObjectifyService.ofy().save().entity(SymbolStore("THB")).now()
        ObjectifyService.ofy().save().entity(SymbolStore("BTC")).now()
        ObjectifyService.ofy().save().entity(SymbolStore("OMG")).now()
        ObjectifyService.ofy().save().entity(SymbolStore("XRP")).now()
        ObjectifyService.ofy().save().entity(SymbolStore("ETH")).now()

        ObjectifyService.ofy().save().entity(PairStore(
                1,
                Ref.create(ObjectifyService.ofy().load().type(SymbolStore::class.java).id("THB").safe()),
                Ref.create(ObjectifyService.ofy().load().type(SymbolStore::class.java).id("BTC").safe())))

        ObjectifyService.ofy().save().entity(PairStore(
                25,
                Ref.create(ObjectifyService.ofy().load().type(SymbolStore::class.java).id("THB").safe()),
                Ref.create(ObjectifyService.ofy().load().type(SymbolStore::class.java).id("XRP").safe())))

        ObjectifyService.ofy().save().entity(PairStore(
                26,
                Ref.create(ObjectifyService.ofy().load().type(SymbolStore::class.java).id("THB").safe()),
                Ref.create(ObjectifyService.ofy().load().type(SymbolStore::class.java).id("OMG").safe())))

        ObjectifyService.ofy().save().entity(PairStore(
                21,
                Ref.create(ObjectifyService.ofy().load().type(SymbolStore::class.java).id("THB").safe()),
                Ref.create(ObjectifyService.ofy().load().type(SymbolStore::class.java).id("ETH").safe())))
    }
}
