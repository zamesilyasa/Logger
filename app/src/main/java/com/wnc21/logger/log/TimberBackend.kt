package com.wnc21.logger.log

import com.wnc21.logger.LoggerBackend
import timber.log.Timber

class TimberBackend : LoggerBackend {
    override fun v(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Timber.v(error, msg.toString())
        } else {
            Timber.v(msg.toString())
        }
    }

    override fun d(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Timber.d(error, msg.toString())
        } else {
            Timber.d(msg.toString())
        }
    }

    override fun i(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Timber.i(error, msg.toString())
        } else {
            Timber.i(msg.toString())
        }
    }

    override fun w(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Timber.w(error, msg.toString())
        } else {
            Timber.w(msg.toString())
        }
    }

    override fun e(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Timber.e(error, msg.toString())
        } else {
            Timber.e(msg.toString())
        }
    }

    override fun tmp(msg: Any?, tag: String?, error: Throwable?) {
        if (error != null) {
            Timber.d(error, msg.toString())
        } else {
            Timber.d(msg.toString())
        }
    }
}