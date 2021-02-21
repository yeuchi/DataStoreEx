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

/*
 * this is essentially a repository
 */
class PrefsStoreImpl: IPrefsStore {

    private val STORE_NAME = "learning_data_store"
    private val prefStore: DataStore<Preferences>
    val PREFS_NAME = "learning_companion_preferences"
    val BOOLEAN_FLAG = "boolean_flag"
    val STRING_FLAG = "string_flag"

    constructor(context:Context) {
        prefStore = context.createDataStore( name = STORE_NAME,
            migrations = listOf(SharedPreferencesMigration(context, PREFS_NAME))
        )
    }

    override fun getBoolean(): Flow<Boolean> {
        return prefStore.data.map { it[preferencesKey<Boolean>(BOOLEAN_FLAG)]?: false }
    }

    override suspend fun setBoolean(flag:Boolean) {
        prefStore.edit {
            it[preferencesKey<Boolean>(BOOLEAN_FLAG)] = flag
        }
    }

    override fun getString(): Flow<String> {
        return prefStore.data.map { it[preferencesKey<String>(STRING_FLAG)]?: "" }
    }

    override suspend fun setString(str:String) {
        prefStore.edit {
            it[preferencesKey<String>(STRING_FLAG)] = str
        }
    }
}