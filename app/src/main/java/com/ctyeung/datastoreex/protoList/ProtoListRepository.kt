package com.ctyeung.datastoreex.protoList

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import com.ctyeung.datastoreex.DataItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/*
 * https://developers.google.com/protocol-buffers/docs/proto3#scalar
 * ProtoBuffer documentation
 *
 * Example of list - useless
 * https://stackoverflow.com/questions/64430872/how-to-save-a-list-of-objects-with-proto-datastore
 *
 * Example code - C++, C#, not Kotlin
 * https://github.com/protocolbuffers/protobuf
 */
class ProtoListRepository {
    private val protoList: DataStore<DataItem>
    private val DATA_STORE_FILE_NAME = "dev_proto.pb"

    constructor(context: Context) {
        protoList = context.createDataStore(
            fileName = DATA_STORE_FILE_NAME,
            serializer = DataItemProtoSerializer
        )
    }

    fun getDataItem():Flow<DataItem> {
        return protoList.data.map {it}
    }

    suspend fun setDataItem(index:Int, num:Int) {
        protoList.updateData {
            if(index > it.toBuilder().numCount-1) {
                it.toBuilder().addNum(num).build()
            }
            else {
                it.toBuilder().setNum(index, num).build()
            }
        }
    }
}