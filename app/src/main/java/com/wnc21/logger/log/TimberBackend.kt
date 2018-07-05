package com.wnc21.logger.log

import com.wnc21.logger.LoggerBackend
import timber.log.Timber

class TimberBackend : LoggerBackend {

    override fun v(msg: Any?) = Timber.v(msg.toString())

    override fun v(msg: String) = Timber.v(msg)

    override fun v(error: Throwable, msg: String?) = Timber.v(error, msg)

    override fun d(msg: Any?) = Timber.d(msg.toString())

    override fun d(msg: String) = Timber.d(msg)

    override fun d(error: Throwable, msg: String?) = Timber.d(error, msg)

    override fun i(msg: Any?) = Timber.i(msg.toString())

    override fun w(msg: Any?) = Timber.w(msg.toString())

    override fun w(msg: String) = Timber.w(msg)

    override fun w(error: Throwable, msg: String?) = Timber.w(error, msg)

    override fun e(msg: Any?) = Timber.e(msg.toString())

    override fun e(msg: String) = Timber.e(msg)

    override fun e(error: Throwable, msg: String?) = Timber.e(error, msg)

    override fun tmp(msg: String) {
        Timber.e("|__TEMP__|$msg")
    }
}