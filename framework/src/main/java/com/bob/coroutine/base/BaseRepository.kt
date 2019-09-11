package com.bob.coroutine.base

open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> BaseBean<T>): BaseBean<T> {
        return call.invoke()
    }

}