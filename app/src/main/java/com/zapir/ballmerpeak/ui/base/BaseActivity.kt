package com.zapir.ballmerpeak.ui.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.zapir.ballmerpeak.BallmerPeakApplication
import com.zapir.ballmerpeak.domain.navigation.BaseNavigator
import org.slf4j.LoggerFactory
import ru.terrakok.cicerone.Navigator

abstract class BaseActivity : MvpAppCompatActivity() {

    abstract val layoutRes: Int
    protected abstract val navigator: BaseNavigator
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

    override fun onResumeFragments() {
        super.onResumeFragments()
        BallmerPeakApplication.INSTANCE.getRouter().setNavigator(navigator)
    }

    override fun onPause() {
        BallmerPeakApplication.INSTANCE.getRouter().removeNavigator()
        super.onPause()
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
}