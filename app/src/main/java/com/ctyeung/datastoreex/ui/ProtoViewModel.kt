package com.ctyeung.datastoreex.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ctyeung.datastoreex.protostore.IProtoStore
import com.ctyeung.datastoreex.protostore.ProtoStoreImpl

class ProtoViewModel (application: Application) : AndroidViewModel(application) {

    private val protoStore:IProtoStore

    init {
        protoStore = ProtoStoreImpl(getApplication<Application>().applicationContext)

    }
}