package com.bob.coroutine.net.exception

import org.json.JSONObject

class ApiException : RuntimeException {

    private var code: Int = -1
        get
    private lateinit var msg: String
    private var data: JSONObject? = null
        get

    constructor(msg: String) : super(msg) {
        this.msg = msg
    }

    constructor(code: Int, msg: String, data: JSONObject) : super(msg) {
        this.code = code
        this.data = data
    }



}