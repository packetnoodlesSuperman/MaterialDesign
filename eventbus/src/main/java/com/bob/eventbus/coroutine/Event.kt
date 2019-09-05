package com.bob.eventbus.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import java.lang.Exception

data class Event<T>(
    val coroutineScope: CoroutineScope,
    val eventDispatcher: CoroutineDispatcher,
    val onEvent: (T) -> Unit,
    val exception: ((Throwable) -> Unit)? = null
) {

    /**
     * Channel 通道  和java的BlockingQueue概念类似
     *
     * Channel可以实现协程之间的数据通信
     * BlockingQueue的put和take 相当于Channel的send和receive操作
     * BlockingQueue 是阻塞操作而 Channel 都是挂起操作
     *
     * Channel为通道，有入口和出口，因此最底层继承SendChannel & ReceiveChannel
     *
     */
    private val channel = Channel<T>()

    init {
        coroutineScope.launch {
            channel.consumeEach {
                launch(eventDispatcher) {
                    if (exception != null) {
                        try {
                            onEvent(it)
                        } catch (e: Exception) {
                            exception.invoke(e)
                        }
                    } else {
                        onEvent(it)
                    }
                }
            }
        }
    }

    fun postEvent(event: Any) {
        if (!channel.isClosedForSend) {
            coroutineScope.launch {
                channel.send(event as T)
            }
        } else {
            println("Channel is closed for send")
        }
    }

    fun cancel() {
        channel.cancel()
    }

}