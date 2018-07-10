package com.wnc21.logger

import android.util.Log

class AndroidBackend(private val tagExtractor: TagExtractor = DefaultTagExtractor()) : LoggerBackend {

    override fun v(msg: Any?, tag: String?, error: Throwable?) {
        val androidTag = extractTag(tag)
        if (error != null) {
            Log.v(androidTag, msg.toString(), error)
        }

        Log.v(androidTag, msg.toString())
    }

    override fun d(msg: Any?, tag: String?, error: Throwable?) {
        val androidTag = extractTag(tag)
        if (error != null) {
            Log.d(androidTag, msg.toString(), error)
        }

        Log.d(androidTag, msg.toString())
    }

    override fun i(msg: Any?, tag: String?, error: Throwable?) {
        val androidTag = extractTag(tag)
        if (error != null) {
            Log.i(androidTag, msg.toString(), error)
        }

        Log.i(androidTag, msg.toString())
    }

    override fun w(msg: Any?, tag: String?, error: Throwable?) {
        val androidTag = extractTag(tag)
        if (error != null) {
            Log.w(androidTag, msg.toString(), error)
        }

        Log.w(androidTag, msg.toString())
    }

    override fun e(msg: Any?, tag: String?, error: Throwable?) {
        val androidTag = extractTag(tag)
        if (error != null) {
            Log.e(androidTag, msg.toString(), error)
        }

        Log.e(androidTag, msg.toString())
    }

    override fun tmp(msg: Any?, tag: String?, error: Throwable?) {
        val androidTag = extractTag(tag)
        if (error != null) {
            Log.d(androidTag, msg.toString(), error)
        }

        Log.d(androidTag, msg.toString())
    }

    private fun extractTag(tag: String?): String {
        return tag ?: tagExtractor.tag()
    }
}