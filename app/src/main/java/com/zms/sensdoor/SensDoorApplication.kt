package com.zms.sensdoor

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SensDoorApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}