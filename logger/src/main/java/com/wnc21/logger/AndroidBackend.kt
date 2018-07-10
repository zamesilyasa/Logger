package com.wnc21.logger

import android.util.Log

class AndroidBackend(autoTag: Boolean = true) : LoggerBackend {

    override fun v(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Log.v(tag, msg.toString(), error)
        }

        Log.v(tag, msg.toString())
    }

    override fun d(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Log.d(tag, msg.toString(), error)
        }

        Log.d(tag, msg.toString())
    }

    override fun i(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Log.i(tag, msg.toString(), error)
        }

        Log.i(tag, msg.toString())
    }

    override fun w(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Log.w(tag, msg.toString(), error)
        }

        Log.w(tag, msg.toString())
    }

    override fun e(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Log.e(tag, msg.toString(), error)
        }

        Log.e(tag, msg.toString())
    }

    override fun tmp(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Log.d(tag, msg.toString(), error)
        }

        Log.d(tag, msg.toString())
    }
}