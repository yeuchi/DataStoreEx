package com.ctyeung.datastoreex.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ctyeung.datastoreex.Record
import com.ctyeung.datastoreex.protomap.ProtoMapRepository
import kotlinx.coroutines.launch

class MapViewModel (application: Application) : AndroidViewModel(application) {

    private val protoMapRepo:ProtoMapRepository
    val map:LiveData<Record>

    init {
        protoMapRepo = ProtoMapRepository(getApplication<Application>().applicationContext)
        map = protoMapRepo.getRecord().asLiveData()
    }

    fun setRecord(key:String, value:String) {
        viewModelScope.launch {
            protoMapRepo.setRecord(key, value)
        }
    }
}