package com.ctyeung.datastoreex.protomap

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import com.ctyeung.datastoreex.DataItem
import com.ctyeung.datastoreex.Record
import com.ctyeung.datastoreex.protoList.DataItemProtoSerializer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProtoMapRepository {
    private val protoMap: DataStore<Record>
    private val MAP_DATA_FILE_NAME = "proto_map.pb"

    constructor(context: Context) {
        protoMap = context.createDataStore(
            fileName = MAP_DATA_FILE_NAME,
            serializer = DataMapProtoSerializer
        )
    }

    fun getRecord(): Flow<Record> {
        return protoMap.data.map { it }
    }

    suspend fun setRecord(key:String, value:String) {
        protoMap.updateData {
            it.toBuilder().putHash(key, value).build()
        }
    }
}