package com.wnc21.logger.analytics

import android.app.Activity
import com.google.android.gms.analytics.GoogleAnalytics
import com.wnc21.logger.LoggerBackend

class GoogleAnalyticsBackend(private val analytics: GoogleAnalytics, private val loggerBackend: LoggerBackend) : LoggerBackend by loggerBackend {

    override fun i(msg: Any?, tag: String?, error: Throwable?) {
        if (msg != null && msg is LogActivityMessageStart) {
            msg.log(analytics)
        } else {
            loggerBackend.i(msg, tag, error)
        }
    }
}

data class LogActivityMessageStart(val activity: Activity) {
    fun log(analytics: GoogleAnalytics) {
        analytics.reportActivityStart(activity)
    }
}