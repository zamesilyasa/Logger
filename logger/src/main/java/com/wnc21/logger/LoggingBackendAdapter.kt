package com.wnc21.logger

open class LoggingBackendAdapter : LoggerBackend {

    override fun v(msg: Any?) {}

    override fun v(msg: String) {}

    override fun v(error: Throwable, msg: String?) {}

    override fun d(msg: Any?) {}

    override fun d(msg: String) {}

    override fun d(error: Throwable, msg: String?) {}

    override fun i(msg: Any?) {}

    override fun w(msg: Any?) {}

    override fun w(msg: String) {}

    override fun w(error: Throwable, msg: String?) {}

    override fun e(msg: Any?) {}

    override fun e(msg: String) {}

    override fun e(error: Throwable, msg: String?) {}

    override fun tmp(msg: String) {}
}