package com.wnc21.logger

data class ApiMessage(val msg: String) {

    fun safeToString(): String {
        return "Safe message $msg"
    }
}