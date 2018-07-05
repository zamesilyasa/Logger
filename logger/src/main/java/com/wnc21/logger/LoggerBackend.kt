package com.wnc21.logger

interface LoggerBackend {

    /**
     * Verbose level object
     */
    fun v(msg: Any?)

    /**
     * Verbose level message
     */
    fun v(msg: String)

    /**
     * Verbose level error
     */
    fun v(error: Throwable, msg: String? = null)


    /**
     * Debug level object
     */
    fun d(msg: Any?)

    /**
     * Debug level message
     */
    fun d(msg: String)

    /**
     * Debug level error
     */
    fun d(error: Throwable, msg: String? = null)

    /**
     * Information level object; for more information @see {@link #d()}
     *
     * This level is usually used for logging information for
     */
    fun i(msg: Any?)

    /**
     * Warning level object
     */
    fun w(msg: Any?)

    /**
     * Warning level message
     */
    fun w(msg: String)

    /**
     * Warning level error
     */
    fun w(error: Throwable, msg: String? = null)

    /**
     * Error level object
     */
    fun e(msg: Any?)

    /**
     * Error level message
     */
    fun e(msg: String)

    /**
     * Fatal error
     */
    fun e(error: Throwable, msg: String? = null)

    /**
     * Temporary message, which is used only for now. These logs should be removed before commits.
     */
    fun tmp(msg: String)
}