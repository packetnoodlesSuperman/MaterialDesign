package com.bob.coroutine.test

import androidx.lifecycle.Observer
import com.bob.coroutine.base.BaseActivity
import com.bob.framework.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.cancel

class MainActivity : BaseActivity<MainViewModel>() {

    override fun providerVMClass(): Class<MainViewModel>  = MainViewModel::class.java

    override fun getLayoutId(): Int  = R.layout.activity_main

    override fun initData() {
        viewModel.testLoadData(0)
        viewModel.mArticleList.observe(this, Observer {
            tvTestTestText.text = it?.size.toString()
        })
    }

}