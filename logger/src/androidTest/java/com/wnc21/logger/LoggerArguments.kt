package com.wnc21.logger

data class LoggerArguments(val level: Level, val msg: Any?, val tag: String?, val error: Throwable?)

enum class Level {
    VERBOSE, DEBUG, INFO, WARNING, ERROR, TEMP
}