package com.ctyeung.datastoreex.protostore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.createDataStore
import com.ctyeung.datastoreex.Developer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/*
 * this is essentially a repository
 */
class ProtoStoreImpl : IProtoStore {

    private val protoStore: DataStore<Developer>
    private val DATA_STORE_FILE_NAME = "dev_proto.pb"

    constructor(context: Context) {
        protoStore = context.createDataStore(
            fileName = "dev_proto.pb",
            serializer = DevProtoSeriaizer
        )
    }

    override fun getDeveloper(): Flow<Developer> {
        return protoStore.data.map { it }
    }

    override suspend fun setDev(name:String) {
        protoStore.updateData { it ->
            it.toBuilder().setName(name).build()
        }
    }

    override suspend fun setDev(id:Int) {
        protoStore.updateData { it ->
            it.toBuilder().setId(id).build()
        }
    }

    override suspend fun setDev(flag:Boolean) {
        protoStore.updateData { it ->
            it.toBuilder().setIsRemote(flag).build()
        }
    }
}