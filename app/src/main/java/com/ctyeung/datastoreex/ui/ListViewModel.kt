package com.ctyeung.datastoreex.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ctyeung.datastoreex.DataItem
import com.ctyeung.datastoreex.protoList.ProtoListRepository
import kotlinx.coroutines.launch

class ListViewModel (application: Application) : AndroidViewModel(application) {

    private val protoListStore:ProtoListRepository
    val list:LiveData<DataItem>

    init {
        protoListStore = ProtoListRepository(getApplication<Application>().applicationContext)
        list = protoListStore.getDataItem().asLiveData()
    }

    fun setDataItem(index:Int, string:String) {
        viewModelScope.launch {
            protoListStore.setDataItem(index, string)
        }
    }
}