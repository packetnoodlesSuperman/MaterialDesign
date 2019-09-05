package com.bob.coroutine.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.MainScope

//该批注的作用是给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默
//@SuppressWarnings("Registered")
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(setLayoutId())

        val main = MainScope()

    }

    protected abstract fun setLayoutId(): Int



}