package com.wnc21.logger

object Logger : LoggerBackend {
    var backend: LoggerBackend = LoggingBackendAdapter()

    override fun v(msg: Any?, tag: String?, error: Throwable?) =backend.v(msg, tag, error)

    override fun d(msg: Any?, tag: String?, error: Throwable?) = backend.d(msg, tag, error)

    override fun i(msg: Any?, tag: String?, error: Throwable?) = backend.i(msg, tag, error)

    override fun w(msg: Any?, tag: String?, error: Throwable?) = backend.w(msg, tag, error)

    override fun e(msg: Any?, tag: String?, error: Throwable?) = backend.e(msg, tag, error)

    override fun tmp(msg: Any?, tag: String?, error: Throwable?) = backend.tmp(msg, tag, error)
}