package com.ctyeung.datastoreex.protomap

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.ctyeung.datastoreex.DataItem
import com.ctyeung.datastoreex.Record
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object DataMapProtoSerializer : Serializer<Record> {
    override val defaultValue: Record = Record.getDefaultInstance()

    override fun readFrom(input: InputStream): Record {
        try {
            return Record.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: Record, output: OutputStream) {
        t.writeTo(output)
    }
}