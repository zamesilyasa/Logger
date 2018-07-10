**DRAFT**

_**This is just an idea for now, code can be changed in the near future**_

The library is kotlin/android specific, it doesn't have much sense with java projects 

This logger doesn't replace loggers like Timber or andorid.util.Log, but it gives you an additional layer of abstraction, which will help you with logging.

One of the purposes is to log different kind of objects and process them in different ways. For example we can log an analytics event like this

    Logger.i(MyAnalyticsEvent("message"))

In the release build we will add a delegate, which will redirect your analytic logs to a framework

    class GoogleAnalyticsBackend(private val analytics: GoogleAnalytics, private val loggerBackend: LoggerBackend) : LoggerBackend by loggerBackend {
    
        override fun i(msg: Any?, tag: String?, error: Throwable?) {
            if (msg != null && msg is LogActivityMessageStart) {
                msg.log(analytics)
            } else {
                loggerBackend.i(msg, tag, error)
            }
        }
    }

Sometimes we want to log some data, which could be sensitive and we don't want to share this information to logcat or crashlytics logs

    class ApiLogger(private val backend: LoggerBackend) : LoggerBackend by backend {
        
        override fun i(msg: Any?, tag: String?, error: Throwable?) {
            if (msg != null && msg is ApiMessage) {
                backend.i(msg.safeToString())
            } else {
                backend.i(msg)
            }
        }
    }


There are situations when logging is used instead of debugging. In this case developers use logs like this: 
    
    Log.e("AAAA", "FFFFFFFFF $data")
 
Sometimes developers forget to remove these logs and push them to repositories what's not good

That's why Logger.tmp() was added. You can easily find usages of this method and remove all the trash logs

    Logger.tmp("FFFFFFFFF $data")

In some cases we'd like to add our own log levels to the logger. Usually loggers are static classes, but in our case we have an object, so we can write an extension to the logger in a very simple way

    fun Logger.sayHello(msg: String) = 
            Toast.makeText(Application.instance, msg, Toast.LENGTH_SHORT).show()


Of course initialization should be very simple and clear. I highly recommend you to use Timber as a logger backend

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
    
Of course we want to be able to test our analytics messages, or any kind of messages

    @RunWith(AndroidJUnit4::class)
    class TestLoginAnalyticsEvent {
    
        @Test
        fun shouldLogLoginSuccessEvent() {
            val logger = object: LoggingBackendAdapter() {
                var event: Any? = null
                override fun i(msg: Any?, tag: String?, error: Throwable?) {
                    event = msg
                }
            }
    
            val loginInteractor = LoginInteractor()
            loginInteractor.login("Ilias", "12345")
    
            assertThat(logger.event as ApiMessage, `is`(ApiMessage("login success")))
        }
    }
