package com.bob.coroutine.test

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bob.coroutine.base.BaseViewModel
import kotlinx.coroutines.*

class MainViewModel : BaseViewModel() {

    private val repository by lazy { MainRepository() }

    val mArticleList: MutableLiveData<List<TestBean.Article>> = MutableLiveData()

    fun testLoadData(page: Int) {
        launchUI({
            Log.e("adfsaf", it.message)
            mArticleList.postValue(null)
        }) {
            launchIO {
                var testLoadData = repository.testLoadData(page)
//                Log.e("adfsaf", testLoadData?.value?.data.toString())
                mArticleList.postValue(testLoadData.data.datas)
            }
        }
    }

}