package com.walker.modulo4aula2

import android.app.IntentService
import android.content.Intent
import android.util.Log


class CounterIntentService : IntentService("CounterIntentService") {
    private val TAG = "CounterIntentService"

    private var stopCondition: Boolean = false

    override fun onHandleIntent(intent: Intent?) {
        for (i in 1..5) {
            if (stopCondition) return
            Log.d(TAG, "Counter: $i")
            Thread.sleep(1000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopCondition = true
    }
}