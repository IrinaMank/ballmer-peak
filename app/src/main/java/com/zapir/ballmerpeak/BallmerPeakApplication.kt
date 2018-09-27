package com.zapir.ballmerpeak

import android.app.Application
import com.zapir.ballmerpeak.domain.PreferencesManager

class BallmerPeakApplication : Application() {


    companion object {

        lateinit var preferencesManager: PreferencesManager

    }

    override fun onCreate() {
        super.onCreate()
        preferencesManager = PreferencesManager(this)
    }

}