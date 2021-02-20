package com.ctyeung.datastoreex.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.ctyeung.datastoreex.prefsstore.IPrefsStore
import com.ctyeung.datastoreex.prefsstore.PrefsStoreImpl

class PreferenceViewModel (application: Application) : AndroidViewModel(application) {

    /*
     * Should wrap data source in repository
     */
    private lateinit var dataStore:IPrefsStore
    var booleanFlag:LiveData<Boolean>

    constructor() {
        dataStore = PrefsStoreImpl(getApplication<Application>().applicationContext)
    }

    init {
        booleanFlag = dataStore.isBooleanTrue().asLiveData()
    }
}