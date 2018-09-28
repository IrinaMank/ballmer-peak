package com.zapir.ballmerpeak.ui.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import org.slf4j.LoggerFactory

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

    override fun onResumeFragments() {
        logger.info("Lifecycle ${javaClass.simpleName} onResumeFragments")
        super.onResumeFragments()
    }

    override fun onPause() {
        logger.info("Lifecycle ${javaClass.simpleName} onPause")
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