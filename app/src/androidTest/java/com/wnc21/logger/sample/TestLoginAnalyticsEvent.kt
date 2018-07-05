package com.wnc21.logger.sample

import android.support.test.runner.AndroidJUnit4
import com.wnc21.logger.ApiMessage
import com.wnc21.logger.LoggingBackendAdapter
import com.wnc21.logger.LoginInteractor
import com.wnc21.logger.analytics.AnalyticsEvent
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestLoginAnalyticsEvent {

    @Test
    fun shouldLogLoginSuccessEvent() {
        val logger = object: LoggingBackendAdapter() {
            var event: Any? = null
            override fun i(msg: Any?) {
                event = msg
            }
        }

        val loginInteractor = LoginInteractor()
        loginInteractor.login("Ilias", "12345")

        assertThat(logger.event as ApiMessage, `is`(ApiMessage("login success")))
    }

    @Test
    fun shouldSendAnalyticsEvent() {
        val logger = object: LoggingBackendAdapter() {
            var event: Any? = null
            override fun i(msg: Any?) {
                event = msg
            }
        }

        val loginInteractor = LoginInteractor()
        loginInteractor.login("Ilias", "12345")

        assertThat(logger.event as AnalyticsEvent, `is`(AnalyticsEvent("analytics event")))
    }
}