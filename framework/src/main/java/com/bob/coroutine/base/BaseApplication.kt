package com.bob.coroutine.base

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

class BaseApplication : Application() {

    companion object {
        var context: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

    }

}