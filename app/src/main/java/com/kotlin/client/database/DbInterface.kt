package com.kotlin.client.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface DbInterface {

    @Query("Select * FROM TradeDb where trade_id = :id order by trade_id DESC")
    fun getTradeDb(id: Long): List<TradeDb>

    @Insert
    fun insertTrade(pair: TradeDb): Long

    @Insert
    fun insertPair(pair: PairDb): Long

    @Insert
    fun insertSymbol(pair: SymbolDb): Long

    @Query("Select * FROM TradeDb where trade_id = :id order by trade_id DESC LIMIT 1")
    fun getLastTradesById(id: Long): TradeDb

}