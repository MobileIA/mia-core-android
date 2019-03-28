package com.mobileia.core.activity

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

abstract class SplashActivity : AppCompatActivity() {
    /**
     * Segundos que dura el Splash
     */
    var splashDuration = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpTimer()
    }

    fun setUpTimer() {
        object : CountDownTimer((splashDuration * 1000).toLong(), 1000) {
            override fun onTick(l: Long) {

            }

            override fun onFinish() {
                onCompleted()
                // Close Splash
                finish()
            }
        }.start()
    }

    abstract fun onCompleted()
}