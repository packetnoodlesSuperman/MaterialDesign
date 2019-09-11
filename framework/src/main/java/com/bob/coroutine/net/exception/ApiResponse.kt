package com.bob.coroutine.net.exception

import org.json.JSONObject

class ApiResponse {

    var code: Int = -1
    var msg: String? = null
    var data: JSONObject? = null

    constructor(jsonObject: JSONObject) {
        if (jsonObject.has("msg")) {
            msg = jsonObject.getString("msg")
        }
        if (jsonObject.has("code")) {
            code = jsonObject.getInt("code")
        }
        if (jsonObject.has("data")) {
            data = jsonObject.getJSONObject("data")
        }
    }

}