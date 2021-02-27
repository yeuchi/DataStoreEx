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
class ProtoStoreRepository {

    private val protoStore: DataStore<Developer>
    private val DATA_STORE_FILE_NAME = "dev_proto.pb"

    constructor(context: Context) {
        protoStore = context.createDataStore(
            fileName = DATA_STORE_FILE_NAME,
            serializer = DevProtoSeriaizer
        )
    }

    fun getDeveloper(): Flow<Developer> {
        return protoStore.data.map { it }
    }

    suspend fun setDev(name:String) {
        protoStore.updateData { it ->
            it.toBuilder().setName(name).build()
        }
    }

    suspend fun setDev(id:Int) {
        protoStore.updateData { it ->
            it.toBuilder().setId(id).build()
        }
    }

    suspend fun setDev(flag:Boolean) {
        protoStore.updateData { it ->
            it.toBuilder().setIsRemote(flag).build()
        }
    }
}