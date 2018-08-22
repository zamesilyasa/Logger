package com.wnc21.logger.sample

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.wnc21.logger.Logger

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({Logger.sayHello("Hello martians")}, 2000)
    }
}

fun Logger.sayHello(msg: String) = Toast.makeText(Application.instance, msg, Toast.LENGTH_SHORT).show()