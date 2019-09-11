package com.bob.coroutine.net.converter

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson

class CustomConverterFactory : Converter.Factory {

    private var gson: Gson

    constructor(gson: Gson) {
        this.gson = gson
    }

    companion object {
        fun create(): CustomConverterFactory {
            return CustomConverterFactory(Gson())
        }
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody>? {
        val adapter = gson.getAdapter(TypeToken.get(type))
        return CustomRequestBodyConverter(gson, adapter)
    }

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        return CustomResponseBodyConverter<RequestBody>()
    }

}