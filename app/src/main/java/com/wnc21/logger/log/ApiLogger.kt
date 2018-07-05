package com.wnc21.logger.log

import com.wnc21.logger.ApiMessage
import com.wnc21.logger.LoggerBackend

class ApiLogger(private val backend: LoggerBackend) : LoggerBackend by backend {
    override fun i(msg: Any?) {
        if (msg != null && msg is ApiMessage) {
            backend.i(msg.safeToString())
        } else {
            backend.i(msg)
        }
    }
}