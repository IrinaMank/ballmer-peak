package com.zapir.ballmerpeak

import android.app.Application
import com.zapir.ballmerpeak.domain.PreferencesManager
import com.zapir.ballmerpeak.domain.navigation.NavigatorHolder
import com.zapir.ballmerpeak.domain.navigation.Router


class BallmerPeakApplication : Application() {


    companion object {
        lateinit var INSTANCE: BallmerPeakApplication
        private lateinit var preferencesManager: PreferencesManager
        private var router: NavigatorHolder = com.zapir.ballmerpeak.domain.navigation.Router()
        private lateinit var navigationHolder: NavigatorHolder

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        preferencesManager = PreferencesManager(this)
        router = Router()
    }

    fun getNavigatorHolder(): NavigatorHolder {
        return router
    }

    fun getPreferenceManager(): PreferencesManager {
        return preferencesManager
    }
}