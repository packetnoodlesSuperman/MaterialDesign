package com.bob.coroutine.doc.sample

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Scope {

    fun launch() {
        //在GlobalScope启动了一个新的协程
        //CoroutineScope
        GlobalScope.launch {
            delay(1000L)
            println("World! ${Thread.currentThread().name}")
        }

        println("Hello ${Thread.currentThread().name} ")
        Thread.sleep(5000L)
    }



}