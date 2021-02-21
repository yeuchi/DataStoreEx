package com.ctyeung.datastoreex.prefsstore

import kotlinx.coroutines.flow.Flow

interface IPrefsStore {
    fun getBoolean(): Flow<Boolean>
    suspend fun setBoolean(flag:Boolean)

    fun getString(): Flow<String>
    suspend fun setString(str:String)
}