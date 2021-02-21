package com.ctyeung.datastoreex.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ctyeung.datastoreex.Developer
import com.ctyeung.datastoreex.protostore.IProtoStore
import com.ctyeung.datastoreex.protostore.ProtoStoreImpl
import kotlinx.coroutines.launch

class ProtoViewModel (application: Application) : AndroidViewModel(application) {

    private val protoStore:IProtoStore
    val protoDev:LiveData<Developer>

    init {
        protoStore = ProtoStoreImpl(getApplication<Application>().applicationContext)
        protoDev = protoStore.getDeveloper().asLiveData()
    }

    fun setDev(name:String) {
        viewModelScope.launch {
            protoStore.setDev(name)
        }
    }

    fun setDev(id:Int) {
        viewModelScope.launch {
            protoStore.setDev(id)
        }
    }

    fun setDev(isRemote:Boolean) {
        viewModelScope.launch {
            protoStore.setDev(isRemote)
        }
    }
}