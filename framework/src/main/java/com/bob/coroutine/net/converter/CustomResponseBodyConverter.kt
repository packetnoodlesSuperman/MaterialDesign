package com.bob.coroutine.net.converter

import com.bob.coroutine.net.exception.ApiException
import com.bob.coroutine.net.exception.ApiResponse
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Converter

class CustomResponseBodyConverter<T> : Converter<ResponseBody, T> {

    override fun convert(value: ResponseBody): T? {

        var response = value.string().trim()
        try {
            var jsonObject = JSONObject(response)
            var apiResponse = ApiResponse(jsonObject)

            if (apiResponse.code == 400) {
                throw ApiException("这里出现错误了")
            }
        } finally {

        }
        throw ApiException("没有出现错误")
    }
}