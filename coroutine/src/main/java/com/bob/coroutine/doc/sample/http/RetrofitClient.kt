
package com.bob.coroutine.doc.sample.http

import kotlinx.coroutines.*
import retrofit2.Retrofit
import java.lang.Exception

object RetrofitClient {

    val BASE_URL = "https://wanandroid.com/"

    val apiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(null)
            .build()

        return@lazy retrofit.create(ApiService::class.java)
    }

    fun <T> executeRequest(request: suspend () -> T?, onSuccess: (T) -> Unit = {},
                           onFail: (Throwable) -> Unit = {}): Job {

        val uiScope = CoroutineScope(Dispatchers.Main)
        return uiScope.launch {
            try {
                val res: T? = withContext(Dispatchers.IO) {request()}

                res?.let(onSuccess)
            } catch (e: CancellationException) {

            } catch (e: Exception) {
                onFail(e)
            }

        }
    }

}

