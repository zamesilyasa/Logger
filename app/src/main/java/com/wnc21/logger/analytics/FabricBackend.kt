package com.wnc21.logger.analytics

import com.crashlytics.android.Crashlytics
import com.wnc21.logger.LoggerBackend

class FabricBackend(val backend: LoggerBackend) : LoggerBackend by backend {

    override fun w(msg: Any?, tag: String?, error: Throwable?) {
        Crashlytics.logException(error)
    }

    override fun e(msg: Any?, tag: String?, error: Throwable?) {
        Crashlytics.logException(error)
    }
}