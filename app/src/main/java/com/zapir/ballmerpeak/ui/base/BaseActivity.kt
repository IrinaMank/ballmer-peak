package com.zapir.ballmerpeak.ui.base

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.zapir.ballmerpeak.BallmerPeakApplication
import com.zapir.ballmerpeak.R
import com.zapir.ballmerpeak.Screens
import com.zapir.ballmerpeak.domain.navigation.BaseNavigator
import com.zapir.ballmerpeak.ui.MainActivity
import com.zapir.ballmerpeak.ui.MainFragment
import com.zapir.ballmerpeak.ui.drinking.DrinkingActivity
import com.zapir.ballmerpeak.ui.setup.InitialFragment
import org.slf4j.LoggerFactory
import ru.terrakok.cicerone.Navigator

abstract class BaseActivity : MvpAppCompatActivity() {

    abstract val layoutRes: Int
    val logger = LoggerFactory.getLogger(this.javaClass.simpleName)

    override fun onCreate(savedInstanceState: Bundle?) {
        logger.info("Lifecycle ${javaClass.simpleName} onCreate")
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        logger.info("Lifecycle ${javaClass.simpleName} onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onRestart() {
        logger.info("Lifecycle  ${javaClass.simpleName} onRestart")
        super.onRestart()
    }

    override fun onStart() {
        logger.info("Lifecycle ${javaClass.simpleName} onStart")
        super.onStart()
    }

    override fun onResume() {
        logger.info("Lifecycle ${javaClass.simpleName} onResume")
        super.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        logger.info("Lifecycle ${javaClass.simpleName} onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        logger.info("Lifecycle ${javaClass.simpleName} onStop")
        super.onStop()
    }

    override fun onDestroy() {
        logger.info("Lifecycle ${javaClass.simpleName} onDestroy ")
        super.onDestroy()
    }

    protected fun getFlowIntent(flowKey: String, data: Any?): Intent? = when (flowKey) {
        //Screens.AUTH_FLOW -> AuthActivity.getStartIntent(this)
        Screens.MAIN_FLOW -> MainActivity.getStartIntent(this)
        Screens.DRINK_FLOW -> {
            val (x, y) = data as Pair<Long, Long>
            DrinkingActivity.getStartIntent(x, y, this)
        }
        else -> null
    }
}