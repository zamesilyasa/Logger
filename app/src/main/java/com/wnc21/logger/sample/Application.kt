package com.wnc21.logger.sample

import com.google.android.gms.analytics.GoogleAnalytics
import com.wnc21.logger.AndroidBackend
import com.wnc21.logger.EmptyBackend
import com.wnc21.logger.Logger
import com.wnc21.logger.analytics.FabricBackend
import com.wnc21.logger.analytics.GoogleAnalyticsBackend
import com.wnc21.logger.log.ApiLogger

class Application: android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Logger.backend = AndroidBackend()
        } else {
            Logger.backend = ApiLogger(GoogleAnalyticsBackend(GoogleAnalytics.getInstance(this), FabricBackend(EmptyBackend())))
        }
    }
}