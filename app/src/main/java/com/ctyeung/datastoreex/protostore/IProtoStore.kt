package com.ctyeung.datastoreex.protostore

import com.ctyeung.datastoreex.Developer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface IProtoStore {
    fun getDeveloper(): Flow<Developer>
    suspend fun setDev(name:String)
    suspend fun setDev(id:Int)
    suspend fun setDev(flag:Boolean)
}