package com.kotlin.client.repository

import com.kotlin.client.api.BxApi
import com.kotlin.client.database.DbInterface
import com.kotlin.client.database.PairDb
import com.kotlin.client.database.TradeDb
import com.kotlin.core.entities.Trade
import com.kotlin.core.entities.Trades

class GetTradesRepositoryImpl(private val db: DbInterface,
                              private val api: BxApi) : GetTradesRepository {
    override fun sync() {
        api.syncTrades().forEach {
            db.updatePair(PairDb(
                    id = it.pairSymbol.id,
                    volume = it.pairSymbol.volume,
                    primaryPairId = it.pairSymbol.primarySymbol,
                    secondaryPairId = it.pairSymbol.secondarySymbol,
                    lastPrice = it.pairSymbol.rate
            ))

            it.listOfTrades.trades.map {
                TradeDb(trade_type = it.trade_type,
                        trade_date = it.trade_date,
                        trade_id = it.trade_id,
                        amount = it.amount,
                        rate = it.rate,
                        pair = it.pair)

            }.map {
                db.insertTrade(it)
            }
        }
    }

    override fun getLastTradesById(id: Long): Trade? {
        val lastTrade = db.getLastTradesById(id)
        if (lastTrade != null) {
            return Trade(trade_id = lastTrade.trade_id,
                    trade_date = lastTrade.trade_date,
                    trade_type = lastTrade.trade_type,
                    amount = lastTrade.amount,
                    rate = lastTrade.rate)
        } else {
            return null
        }
    }

    override fun getTradesPersisted(id: Long): Trades = Trades(db.getTradeDb(id).map {
        Trade(trade_id = it.trade_id,
                trade_date = it.trade_date,
                trade_type = it.trade_type,
                amount = it.amount,
                rate = it.rate)
    }.toList())

    override fun getTradesRemotely(id: Long): Trades = api.getTrades(id)

    override fun saveTrade(trade: TradeDb) {
        db.insertTrade(trade)
    }

}