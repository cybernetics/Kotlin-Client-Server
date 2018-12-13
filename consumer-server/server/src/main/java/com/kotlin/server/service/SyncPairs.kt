package com.kotlin.server.service

import com.kotlin.core.usecases.GetPairs
import javax.inject.Inject


class SyncPairs @Inject constructor(private val getPairs: GetPairs) {

    fun sync() = getPairs.sync()
}