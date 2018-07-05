This logger doesn't replace loggers like Timber or andorid.util.Log, but it gives you an additional layer of abstraction, which will help you with logging.

One of the purposes is to log different kind of objects and process them in different ways. For example we can log an analytics event like this

    Logger.i(MyAnalyticsEvent("message"))

In the release build we will add a delegate, which will redirect your analytic logs to a framework

    class MyAnalyticsBackend(delegate: LoggerBackend) : LoggerBackend by delegate {
    
        override fun i(msg: Any?) {
            if (msg != null && msg is MyAnalyticsMessage) {
                myAnalytics.logEvent(msg)
            }
        }
    }

Sometimes we want to log some data, which could be sensitive and we don't want to share this information to logcat or crashlytics logs

    class MyAnalyticsBackend(delegate: LoggerBackend) : LoggerBackend by delegate {
    
        override fun d(msg: Any?) {
            msg?.let {
                if (it !is UserCredentialsResponse) {
                    super.d(it)
                }
            }
        }
    }


There are situations when logging is used instead of debugging. In this case developers use logs like this: 
    
    Log.e("AAAA", "FFFFFFFFF $data")
 
Sometimes they forget to remove these logs and push them to repositories what's not good

That's why Logger.tmp() was added. You can easily find usages of this method and remove all the trash logs

In some cases we'd like to add our own log levels to the logger. Usually loggers are static classes, but in our case we have an object, so we can write an extension to the logger in a very simple way

fun Logger.sayHello() = throw IllegalStateException("Hello")


Of course initialization should be very simple and clear. I highly recommend you to use Timber as a logger backend

    private fun initLoggers() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Logger.backend = TimberDebugBackend()
        } else {
            Logger.backend = AnalyticsLogger(ApiLogger(TimberReleaseLogger))
        }
    }
    
Of course we want to be able to test our analytics messages, or any kind of messages

    @Test
    fun testEventSent() {
        val logger = object: LoggingBackendAdapter() {
                    var event: Any? = null
                    override fun i(msg: Any?) {
                        super.i(msg)
                    }
                }
           
        val interactor: LoginInteractor(dependency1, dependency2)
        interactor.login("ilias", "123")
        
        Assert.assertNotNull(logger.event)
    }
