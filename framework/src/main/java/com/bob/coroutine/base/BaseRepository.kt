package com.bob.coroutine.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bob.coroutine.bean.BaseBean

open class BaseRepository {

    suspend fun <T : Any> apiCall(call: suspend () -> BaseBean<T>): BaseBean<T> {
        return call.invoke()
    }

}