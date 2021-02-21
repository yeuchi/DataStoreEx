package com.ctyeung.datastoreex.protostore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.ctyeung.datastoreex.Developer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object DevProtoSeriaizer : Serializer<Developer> {
    override val defaultValue: Developer = Developer.getDefaultInstance()

    override fun readFrom(input: InputStream): Developer {
        try {
            return Developer.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: Developer, output: OutputStream) = t.writeTo(output)
}