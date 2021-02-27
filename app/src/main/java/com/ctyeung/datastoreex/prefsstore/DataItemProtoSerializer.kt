package com.ctyeung.datastoreex.prefsstore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.ctyeung.datastoreex.DataItem
import com.ctyeung.datastoreex.Developer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object DataItemProtoSerializer : Serializer<DataItem> {
    override val defaultValue: DataItem = DataItem.getDefaultInstance()

    override fun readFrom(input: InputStream): DataItem {
        try {
            return DataItem.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: DataItem, output: OutputStream) = t.writeTo(output)
}