package com.bob.coroutine.net

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bob.coroutine.bean.BaseBean
import com.bob.coroutine.test.TestBean
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

    @GET("/article/list/{page}/json")
    suspend fun test(@Path("page") page: Int): BaseBean<TestBean>



    //后续会使用到协程，所以这儿将Call换成了Deferred
    @GET
    fun test2(): Deferred<Unit>


}