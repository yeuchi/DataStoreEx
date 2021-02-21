package com.ctyeung.datastoreex.prefsstore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.core.preferencesKey
import com.ctyeung.datastoreex.prefsstore.IPrefsStore
import kotlinx.coroutines.flow.map

class PrefsStoreImpl: IPrefsStore {

    private val STORE_NAME = "learning_data_store"
    private lateinit var dataStore: DataStore<Preferences>
    val PREFS_NAME = "learning_companion_preferences"
    val BOOLEAN_FLAG = "boolean_flag"
    val STRING_FLAG = "string_flag"

    constructor(context:Context) {
        dataStore = context.createDataStore( name = STORE_NAME,
            migrations = listOf(SharedPreferencesMigration(context, PREFS_NAME))
        )
    }

    override fun getBoolean(): Flow<Boolean> {
        return dataStore.data.map { it[preferencesKey<Boolean>(BOOLEAN_FLAG)]?: false }
    }

    override suspend fun setBoolean(flag:Boolean) {
        dataStore.edit {
            it[preferencesKey<Boolean>(BOOLEAN_FLAG)] = flag
        }
    }

    override fun getString(): Flow<String> {
        return dataStore.data.map { it[preferencesKey<String>(STRING_FLAG)]?: "" }
    }

    override suspend fun setString(str:String) {
        dataStore.edit {
            it[preferencesKey<String>(STRING_FLAG)] = str
        }
    }
}