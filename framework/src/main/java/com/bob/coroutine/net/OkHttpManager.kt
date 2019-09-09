package com.bob.coroutine.net

import com.bob.framework.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpManager {

    private const val CONNET_TIME_OUT: Long = 5;
    private const val READ_TIME_OUT: Long = 10;
    private const val WRITE_TIME_OUT: Long = 20;

    val okHttpClient by lazy {
        return@lazy providerOkHttpClient()
    }

    private fun providerOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().apply {
            connectTimeout(CONNET_TIME_OUT, TimeUnit.SECONDS)
            readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
            //添加拦截器  如Token拦截器  请求头等
            addInterceptor(loggingInterceptor())
            //线程池
//            dispatcher(null)
        }.build()

    private fun loggingInterceptor(): Interceptor {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.BASIC
        }
        return logging
    }


}