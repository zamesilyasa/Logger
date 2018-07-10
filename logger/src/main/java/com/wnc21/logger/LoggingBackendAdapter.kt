package com.wnc21.logger

open class LoggingBackendAdapter : LoggerBackend {
    override fun v(msg: Any?, tag: String?, error: Throwable?) {}

    override fun d(msg: Any?, tag: String?, error: Throwable?) {}

    override fun i(msg: Any?, tag: String?, error: Throwable?) {}

    override fun w(msg: Any?, tag: String?, error: Throwable?) {}

    override fun e(msg: Any?, tag: String?, error: Throwable?) {}

    override fun tmp(msg: Any?, tag: String?, error: Throwable?) {}
}