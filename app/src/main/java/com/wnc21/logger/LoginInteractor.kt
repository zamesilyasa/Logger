package com.wnc21.logger

import com.wnc21.logger.analytics.AnalyticsEvent

class LoginInteractor {

    fun login(user: String, password: String) {
        Logger.i(ApiMessage("login success"))
        Logger.i(AnalyticsEvent("analytics event"))
    }
}