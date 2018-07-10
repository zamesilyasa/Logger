package com.wnc21.logger

interface LoggerBackend {

    /**
     * Verbose level object
     */
    fun v(msg: Any? = null, tag: String? = null, error: Throwable? = null)

    /**
     * Debug level object
     */
    fun d(msg: Any? = null, tag: String? = null, error: Throwable? = null)

    /**
     * Info level object; This level is used for meaningful information like analytics objects or objects,
     * which are going to be redirected or filtered
     */
    fun i(msg: Any? = null, tag: String? = null, error: Throwable? = null)

    /**
     * Warning level object
     */
    fun w(msg: Any? = null, tag: String? = null, error: Throwable? = null)

    /**
     * Warning level object
     */
    fun e(msg: Any? = null, tag: String? = null, error: Throwable? = null)

    /**
     * Temporary message, which is used only for now. These logs should be removed before commits.
     */
    fun tmp(msg: Any? = null, tag: String? = null, error: Throwable? = null)
}