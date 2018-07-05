package com.wnc21.logger

object Logger: LoggerBackend {

    var backend: LoggerBackend = LoggingBackendAdapter()

    override fun v(msg: Any?) = backend.d(msg)

    override fun v(msg: String) = backend.d(msg)

    override fun v(error: Throwable, msg: String?) = backend.d(error, msg)

    override fun d(msg: Any?) = backend.d(msg)

    override fun d(msg: String) = backend.d(msg)

    override fun d(error: Throwable, msg: String?) = backend.d(error, msg)

    override fun i(msg: Any?) = backend.i(msg)

    override fun w(msg: Any?) = backend.w(msg)

    override fun w(msg: String) = backend.w(msg)

    override fun w(error: Throwable, msg: String?) = backend.w(error, msg)

    override fun e(msg: Any?) = backend.e(msg)

    override fun e(msg: String) = backend.e(msg)

    override fun e(error: Throwable, msg: String?) = backend.e(error, msg)

    override fun tmp(msg: String) = backend.tmp(msg)
}