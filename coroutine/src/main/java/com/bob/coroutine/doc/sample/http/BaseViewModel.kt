package com.bob.coroutine.doc.sample.http

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), LifecycleObserver {

    fun test() {
        RetrofitClient.executeRequest(
            request = {

            },
            // 成功回调
            onSuccess = {

            },
            //失败的回调
            onFail = {

            }
        )
    }

}