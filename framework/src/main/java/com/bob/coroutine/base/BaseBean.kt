package com.bob.coroutine.base

import java.io.Serializable

data class BaseBean<T>(val code: Int, val msg: String, val data: T): Serializable