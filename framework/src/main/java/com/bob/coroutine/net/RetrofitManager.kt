package com.bob.coroutine.net

import com.bob.coroutine.net.adapter.LiveDataCallAdapterFactory
import com.bob.coroutine.net.converter.CustomConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.ConnectException
import kotlin.coroutines.resumeWithException

object RetrofitManager {

    val apiService by lazy {
        return@lazy provideRetrofit().create(ApiService::class.java)
    }

    private fun provideRetrofit(): Retrofit =
        Retrofit.Builder().apply {
            baseUrl(ApiService.BASE_URL)
            client(OkHttpManager.okHttpClient)
            addConverterFactory(GsonConverterFactory.create())
            addConverterFactory(CustomConverterFactory.create())
            addCallAdapterFactory(LiveDataCallAdapterFactory())
            addCallAdapterFactory(CoroutineCallAdapterFactory())
        }.build()

    //扩展 await() 函数
    private suspend fun <T> Call<T>.await(): T {
        return suspendCancellableCoroutine { continuation ->
            //await()的实质是调用 call的异步enqueue
            enqueue(object : Callback<T> {
                //请求失败
                override fun onFailure(call: Call<T>, t: Throwable) {
                    if (continuation.isCancelled) return // ②  //如果协程已经取消了，无需继续抛出异常
                    continuation.resumeWithException(t)
                }
                //请求成功
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    //1.3版本的新特性 使用 resumeWith(Result<T>)
                    continuation.resumeWith(runCatching { // ①
                        if (response.isSuccessful) {
                            response.body()
                                ?: throw NullPointerException("Response body is null: $response")
                        } else {
                            throw HttpException(response)
                        }
                    })
                }
            })

            //当协程取消时的回调函数，协程取消  -  请求取消
            continuation.invokeOnCancellation {
                try {
                    cancel()
                } catch (ex: Throwable) {  // ③
                    //Ignore cancel exception
                    //此时协程已经取消，请求取消是否存在异常已经没有影响了
                }
            }
        }
    }




}