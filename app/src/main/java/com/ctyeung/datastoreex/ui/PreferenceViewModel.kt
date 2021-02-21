package com.ctyeung.datastoreex.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ctyeung.datastoreex.prefsstore.IPrefsStore
import com.ctyeung.datastoreex.prefsstore.PrefsStoreImpl
import kotlinx.coroutines.launch

class PreferenceViewModel (application: Application) : AndroidViewModel(application) {

    /*
     * Should wrap data source in repository
     */
    private val prefStore:IPrefsStore
    val prefBoolean:LiveData<Boolean>
    val prefString:LiveData<String>

    init {
        prefStore = PrefsStoreImpl(getApplication<Application>().applicationContext)

        prefBoolean = prefStore.getBoolean().asLiveData()
        prefString = prefStore.getString().asLiveData()
    }

    fun setPrefBoolean(flag:Boolean) {
        viewModelScope.launch {
            prefStore.setBoolean(flag)
        }
    }

    fun setPrefString(str:String) {
        viewModelScope.launch {
            prefStore.setString(str)
        }
    }
}