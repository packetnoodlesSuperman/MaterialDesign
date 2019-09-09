package com.bob.coroutine.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders

abstract class BaseActivity<VM: BaseViewModel>: AppCompatActivity() {

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVM()
        setContentView(getLayoutId())
        initData()
    }

    abstract fun providerVMClass(): Class<VM>

    abstract fun getLayoutId(): Int

    abstract fun initData()

    private fun initVM() {
        providerVMClass().let {
            viewModel = ViewModelProviders.of(this).get(it)
            //...
            viewModel.let(lifecycle::addObserver)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.let {
            lifecycle.removeObserver(it)
        }
    }

}