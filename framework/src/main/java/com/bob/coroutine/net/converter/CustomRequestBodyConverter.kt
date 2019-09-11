package com.bob.coroutine.net.converter

import okhttp3.RequestBody
import retrofit2.Converter
import okhttp3.MediaType
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import okio.Buffer
import java.io.OutputStreamWriter
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.nio.charset.Charset
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.google.gson.TypeAdapter
import com.google.gson.Gson
import android.icu.lang.UCharacter.GraphemeClusterBreak.T






class CustomRequestBodyConverter<T> : Converter<T, RequestBody> {

    private val MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8")
    private val UTF_8 = Charset.forName("UTF-8")

    private var gson: Gson
    private var adapter: TypeAdapter<T>

    constructor(gson: Gson, adapter: TypeAdapter<T>) {
        this.gson = gson
        this.adapter = adapter
    }

    override fun convert(value: T): RequestBody? {
//        val content: ByteArray
//        return RequestBody.create(MEDIA_TYPE, value.toString())

        val buffer = Buffer()
        val writer = OutputStreamWriter(buffer.outputStream(), UTF_8)
        val jsonWriter = gson.newJsonWriter(writer)
        adapter.write(jsonWriter, value)
        jsonWriter.close()
        return RequestBody.create(MEDIA_TYPE, buffer.readByteString())
    }
}