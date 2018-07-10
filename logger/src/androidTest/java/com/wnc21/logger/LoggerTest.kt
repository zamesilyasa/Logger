package com.wnc21.logger

import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoggerTest {
    lateinit var backend: TestLoggerBackend

    @Before
    fun before() {
        backend = TestLoggerBackend()
        Logger.backend = this.backend
    }

    @Test
    fun loggerShouldPassAppropriateVerboseArguments() {
        testArguments(Level.VERBOSE)
        testArguments(Level.VERBOSE, "Verbose message")
        testArguments(Level.VERBOSE, "Verbose message", "Verbose tag")
        testArguments(Level.VERBOSE, "Verbose message", "Verbose tag", AssertionError("Verbose error"))
        testArguments(Level.VERBOSE, error = AssertionError("Verbose error"))
        testArguments(Level.VERBOSE, error = AssertionError("Verbose error"), tag = "verbose tag")
        testArguments(Level.VERBOSE, error = AssertionError("Verbose error"), message = "verbose message")
    }

    @Test
    fun loggerShouldPassAppropriateDebugArguments() {
        testArguments(Level.DEBUG)
        testArguments(Level.DEBUG, "Debug message")
        testArguments(Level.DEBUG, "Debug message", "Debug tag")
        testArguments(Level.DEBUG, "Debug message", "Debug tag", AssertionError("Debug error"))
        testArguments(Level.DEBUG, error = AssertionError("Debug error"))
        testArguments(Level.DEBUG, error = AssertionError("Debug error"), tag = "Debug tag")
        testArguments(Level.DEBUG, error = AssertionError("Debug error"), message = "Debug message")
    }

    @Test
    fun loggerShouldPassAppropriateInfoArguments() {
        testArguments(Level.INFO)
        testArguments(Level.INFO, "Info message")
        testArguments(Level.INFO, "Info message", "Info tag")
        testArguments(Level.INFO, "Info message", "Info tag", AssertionError("Info error"))
        testArguments(Level.INFO, error = AssertionError("Info error"))
        testArguments(Level.INFO, error = AssertionError("Info error"), tag = "Info tag")
        testArguments(Level.INFO, error = AssertionError("Info error"), message = "Info message")
    }

    @Test
    fun loggerShouldPassAppropriateWarningArguments() {
        testArguments(Level.WARNING)
        testArguments(Level.WARNING, "Warning message")
        testArguments(Level.WARNING, "Warning message", "Warning tag")
        testArguments(Level.WARNING, "Warning message", "Warning tag", AssertionError("Warning error"))
        testArguments(Level.WARNING, error = AssertionError("Warning error"))
        testArguments(Level.WARNING, error = AssertionError("Warning error"), tag = "Warning tag")
        testArguments(Level.WARNING, error = AssertionError("Warning error"), message = "Warning message")
    }

    @Test
    fun loggerShouldPassAppropriateErrorArguments() {
        testArguments(Level.ERROR)
        testArguments(Level.ERROR, "Error message")
        testArguments(Level.ERROR, "Error message", "Error tag")
        testArguments(Level.ERROR, "Error message", "Error tag", AssertionError("Error level error"))
        testArguments(Level.ERROR, error = AssertionError("Error level error"))
        testArguments(Level.ERROR, error = AssertionError("Error level error"), tag = "Error tag")
        testArguments(Level.ERROR, error = AssertionError("Error level error"), message = "Error message")
    }

    private fun testArguments(level: Level, message: Any? = null, tag: String? = null, error: Throwable? = null) {
        backend.arguments = null

        when (level) {
            Level.VERBOSE -> Logger.v(message, tag, error)
            Level.DEBUG -> Logger.d(message, tag, error)
            Level.INFO -> Logger.i(message, tag, error)
            Level.WARNING -> Logger.w(message, tag, error)
            Level.ERROR -> Logger.e(message, tag, error)
            Level.TEMP -> Logger.tmp(message, tag, error)
        }

        assertThat(backend.arguments, `is`(LoggerArguments(level, message, tag, error)))
    }
}