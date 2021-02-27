package com.ctyeung.datastoreex.protoList

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import com.ctyeung.datastoreex.DataItem
import com.ctyeung.datastoreex.prefsstore.DataItemProtoSerializer

class ProtoListRepository {
    private val protoStore: DataStore<DataItem>
    private val DATA_STORE_FILE_NAME = "dev_proto.pb"

    constructor(context: Context) {
        protoStore = context.createDataStore(
            fileName = DATA_STORE_FILE_NAME,
            serializer = DataItemProtoSerializer
        )
    }
}