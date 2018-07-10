package com.wnc21.logger

class TestLoggerBackend : LoggerBackend {

    var arguments: LoggerArguments? = null

    override fun v(msg: Any?, tag: String?, error: Throwable?) {
        arguments = LoggerArguments(Level.VERBOSE, msg, tag, error)
    }

    override fun d(msg: Any?, tag: String?, error: Throwable?) {
        arguments = LoggerArguments(Level.DEBUG, msg, tag, error)
    }

    override fun i(msg: Any?, tag: String?, error: Throwable?) {
        arguments = LoggerArguments(Level.INFO, msg, tag, error)
    }

    override fun w(msg: Any?, tag: String?, error: Throwable?) {
        arguments = LoggerArguments(Level.WARNING, msg, tag, error)
    }

    override fun e(msg: Any?, tag: String?, error: Throwable?) {
        arguments = LoggerArguments(Level.ERROR, msg, tag, error)
    }

    override fun tmp(msg: Any?, tag: String?, error: Throwable?) {
        arguments = LoggerArguments(Level.TEMP, msg, tag, error)
    }
}