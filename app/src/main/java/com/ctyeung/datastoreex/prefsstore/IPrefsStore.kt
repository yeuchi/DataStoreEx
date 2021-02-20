package com.ctyeung.datastoreex.prefsstore

import kotlinx.coroutines.flow.Flow

interface IPrefsStore {
    fun isBooleanTrue(): Flow<Boolean>

    suspend fun setBoolean(flag:Boolean)
}