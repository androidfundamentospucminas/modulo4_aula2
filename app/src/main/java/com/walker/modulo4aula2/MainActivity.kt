package com.walker.modulo4aula2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val counterIntentService = Intent(this, CounterIntentService::class.java)

        findViewById<Button>(R.id.startButton).setOnClickListener {
            // startService(counterIntentService)

            val worker = OneTimeWorkRequestBuilder<CounterWorker>().build()
            WorkManager.getInstance(applicationContext).enqueue(worker)
        }

        findViewById<Button>(R.id.stopButton).setOnClickListener {
            // stopService(counterIntentService)
            WorkManager.getInstance(applicationContext).cancelAllWork()
        }
    }
}