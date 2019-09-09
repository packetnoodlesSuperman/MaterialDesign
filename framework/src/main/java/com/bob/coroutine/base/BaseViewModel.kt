package com.bob.coroutine.base

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class BaseViewModel : ViewModel(), LifecycleObserver, CoroutineScope {

    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCleared() {
        super.onCleared()
        //取消所有的协程任务
        job.cancel()
    }

    fun launchUI(
        onFail: (Throwable) -> Unit,
        block: suspend CoroutineScope.() -> Unit
    ) {
        launch(Dispatchers.Main) {
            tryCatch(onFail, block)
        }
    }

    suspend fun launchIO(
        block: suspend CoroutineScope.() -> Unit) {
        withContext(Dispatchers.IO) {
            block()
        }
    }

    private suspend fun tryCatch(
        onFail: (Throwable) -> Unit,
        tryBlock: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            try {
                tryBlock()
                Log.e("xhglasdjfa", "---- tryBlock")
            } catch (e: Throwable) {
                if (e !is CancellationException) {
                    Log.e("xhglasdjfa", "---- Throwable a + ${e.message}")
                    e.printStackTrace()
                } else {
                    Log.e("xhglasdjfa", "---- Throwable b")
                    throw e
                }
                onFail(e)
            } finally {
                Log.e("xhglasdjfa", "---- finallyBlock")
            }
        }
    }


}