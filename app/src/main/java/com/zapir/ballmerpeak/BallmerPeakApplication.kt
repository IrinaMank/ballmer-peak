package com.zapir.ballmerpeak

import android.app.Application
import com.zapir.ballmerpeak.domain.PreferencesManager
import com.zapir.ballmerpeak.domain.navigation.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Cicerone





class BallmerPeakApplication : Application() {


    companion object {
        public lateinit var INSTANCE: BallmerPeakApplication
        private lateinit var preferencesManager: PreferencesManager
        private lateinit var cicerone: Cicerone<Router>
        private var router = com.zapir.ballmerpeak.domain.navigation.Router()
        private lateinit var navigationHolder: NavigatorHolder

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        preferencesManager = PreferencesManager(this)
        initCicerone()
    }

    private fun initCicerone() {
        cicerone = Cicerone.create()
    }

    fun getNavigatorHolder(): NavigatorHolder {
        return router
    }

    fun getRouter(): com.zapir.ballmerpeak.domain.navigation.Router {
        return router
    }

    fun getPreferenceManager(): PreferencesManager {
        return preferencesManager
    }
}