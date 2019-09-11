package com.bob.coroutine.test

import com.bob.coroutine.base.BaseRepository
import com.bob.coroutine.base.BaseBean
import com.bob.coroutine.net.RetrofitManager

class MainRepository : BaseRepository() {

    suspend fun testLoadData(page: Int): BaseBean<TestBean> {
        return apiCall {
             RetrofitManager.apiService.test(page)
        }
    }

}