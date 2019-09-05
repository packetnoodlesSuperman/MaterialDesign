package com.bob.coroutine

import android.content.Context
import android.util.Log
import kotlinx.coroutines.CancellationException

fun log(any: Any, content: String?) {
    content?.let {
        Log.e(any.javaClass.simpleName, it)
    }
}

fun Context.toast(content: String) {

}

inline fun tryCatch(catchBlock: (Throwable) -> Unit = {}, tryBlock: () -> Unit) {
    try {
        tryBlock()
    } catch (_: CancellationException) {

    } catch (t: Throwable) {
        catchBlock(t)
    }
}