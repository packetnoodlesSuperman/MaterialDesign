package com.bob.eventbus.coroutine

import kotlinx.coroutines.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.coroutines.CoroutineContext

val UI: CoroutineDispatcher = Dispatchers.Main

/**
 * http://www.imooc.com/article/details/id/291744
 */
object EventBus : CoroutineScope {

    private val job = SupervisorJob()
    private val contextMap = ConcurrentHashMap<String, MutableMap<Class<*>, Event<*>>>()
    private val mStickyEventMap = ConcurrentHashMap<Class<*>, Any>()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + job

    fun <T> register(
        contextName: String,
        eventDispatcher: CoroutineDispatcher = UI,
        eventClass: Class<T>,
        eventCallback: (T) -> Unit
    ) {
        val eventMap = if (contextMap.containsKey(contextName)) {
            contextMap[contextName]!!
        } else {
            val eventMap = mutableMapOf<Class<*>, Event<*>>()
            contextMap[contextName] = eventMap
            eventMap
        }

        eventMap[eventClass] = Event(this, eventDispatcher, eventCallback)
    }

    @JvmStatic
    fun post(event: Any, delayTime: Long = 0) {
        if (delayTime > 0) {
            launch {
                delay(delayTime)
                postEvent(event)
            }
        } else {
            postEvent(event)
        }
    }

    private fun postEvent(event: Any) {
        val cloneContextMap = ConcurrentHashMap<String, MutableMap<Class<*>, Event<*>>>()
        cloneContextMap.putAll(contextMap)
        for ((_, eventMap) in cloneContextMap) {
            eventMap.keys
                .firstOrNull{
                    it == event.javaClass || it == event.javaClass.superclass
                }?.let {
                    key -> eventMap[key]?.postEvent(event)
                }
        }
    }

}

