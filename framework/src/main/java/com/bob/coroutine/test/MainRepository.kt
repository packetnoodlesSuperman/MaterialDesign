package com.bob.coroutine.test

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bob.coroutine.base.BaseRepository
import com.bob.coroutine.bean.BaseBean
import com.bob.coroutine.net.RetrofitManager
import kotlinx.coroutines.Deferred

class MainRepository : BaseRepository() {

    suspend fun testLoadData(page: Int): BaseBean<TestBean> {
        return apiCall {
             RetrofitManager.apiService.test(page)
        }
    }

}