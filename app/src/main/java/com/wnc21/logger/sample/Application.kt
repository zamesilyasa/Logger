package com.wnc21.logger.sample

import com.google.android.gms.analytics.GoogleAnalytics
import com.wnc21.logger.Logger
import com.wnc21.logger.analytics.FabricBackend
import com.wnc21.logger.analytics.GoogleAnalyticsBackend
import com.wnc21.logger.log.ApiLogger
import com.wnc21.logger.log.TimberBackend
import timber.log.Timber

class Application: android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Logger.backend = TimberBackend()
        } else {
            Logger.backend = ApiLogger(GoogleAnalyticsBackend(GoogleAnalytics.getInstance(this), FabricBackend(TimberBackend())))
        }
    }
}