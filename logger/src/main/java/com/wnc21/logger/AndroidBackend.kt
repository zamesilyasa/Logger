package com.wnc21.logger

import android.util.Log

class AndroidBackend(private val tagExtractor: TagExtractor = DefaultTagExtractor()) : LoggerBackend {

    override fun v(msg: Any?, tag: String?, error: Throwable?) {
        if (msg is Throwable) {
            v(null, tag, msg)
            return
        }

        val androidTag = extractTag(tag)
        if (error != null) {
            Log.v(androidTag, msg?.toString(), error)
        } else {
            Log.v(androidTag, msg.toString())
        }
    }

    override fun d(msg: Any?, tag: String?, error: Throwable?) {
        if (msg is Throwable) {
            d(null, tag, msg)
            return
        }

        val androidTag = extractTag(tag)
        if (error != null) {
            Log.d(androidTag, msg?.toString(), error)
        } else {
            Log.d(androidTag, msg.toString())
        }
    }

    override fun i(msg: Any?, tag: String?, error: Throwable?) {
        if (msg is Throwable) {
            i(null, tag, msg)
            return
        }

        val androidTag = extractTag(tag)
        if (error != null) {
            Log.i(androidTag, msg?.toString(), error)
        } else {
            Log.i(androidTag, msg.toString())
        }
    }

    override fun w(msg: Any?, tag: String?, error: Throwable?) {
        if (msg is Throwable) {
            w(null, tag, msg)
            return
        }

        val androidTag = extractTag(tag)
        if (error != null) {
            Log.w(androidTag, msg?.toString(), error)
        } else {
            Log.w(androidTag, msg.toString())
        }

    }

    override fun e(msg: Any?, tag: String?, error: Throwable?) {
        if (msg is Throwable) {
            e(null, tag, msg)
            return
        }

        val androidTag = extractTag(tag)
        if (error != null) {
            Log.e(androidTag, msg?.toString(), error)
        } else {
            Log.e(androidTag, msg.toString())
        }
    }

    override fun tmp(msg: Any?, tag: String?, error: Throwable?) {
        if (msg is Throwable) {
            tmp(null, tag, msg)
            return
        }

        val androidTag = extractTag(tag)
        if (error != null) {
            Log.d(androidTag, msg?.toString(), error)
        } else {
            Log.d(androidTag, msg.toString())
        }
    }

    private fun extractTag(tag: String?): String {
        return tag ?: tagExtractor.tag()
    }
}