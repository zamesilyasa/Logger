package com.wnc21.logger.analytics

import android.app.Activity
import com.google.android.gms.analytics.GoogleAnalytics
import com.wnc21.logger.LoggerBackend

class GoogleAnalyticsBackend(private val analytics: GoogleAnalytics, loggerBackend: LoggerBackend) : LoggerBackend by loggerBackend {

    override fun i(msg: Any?) {
        if (msg != null && msg is LogActivityMessageStart) {
            msg.log(analytics)
        }
    }
}

data class LogActivityMessageStart(val activity: Activity) {
    fun log(analytics: GoogleAnalytics) {
        analytics.reportActivityStart(activity)
    }
}