package com.wnc21.logger.analytics

import com.crashlytics.android.Crashlytics
import com.wnc21.logger.LoggerBackend

class FabricBackend(val backend: LoggerBackend) : LoggerBackend by backend {

    override fun e(error: Throwable, msg: String?) {
        Crashlytics.logException(error)
    }

    override fun w(error: Throwable, msg: String?) {
        Crashlytics.logException(error)
    }
}