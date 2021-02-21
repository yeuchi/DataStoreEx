package com.ctyeung.datastoreex.protostore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import com.ctyeung.datastoreex.Developer

class ProtoStoreImpl : IProtoStore {

    private val protoStore: DataStore<Developer>
    private val DATA_STORE_FILE_NAME = "dev_proto.pb"

    constructor(context: Context) {
        protoStore = context.createDataStore(
            fileName = "dev_proto.pb",
            serializer = DevProtoSeriaizer
        )
    }


}