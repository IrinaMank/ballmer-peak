package com.zapir.ballmerpeak.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.zapir.ballmerpeak.BallmerPeakApplication
import com.zapir.ballmerpeak.R
import com.zapir.ballmerpeak.Screens
import com.zapir.ballmerpeak.domain.navigation.BaseNavigator
import com.zapir.ballmerpeak.presentation.launch.LaunchPresenter
import com.zapir.ballmerpeak.presentation.launch.LaunchView
import com.zapir.ballmerpeak.ui.base.BaseActivity

class MainActivity : BaseActivity(), LaunchView {

    @InjectPresenter
    lateinit var presenter: LaunchPresenter

    @ProvidePresenter
    fun providePresenter(): LaunchPresenter {
        return LaunchPresenter()
    }

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun initMainScreen() {
        super.onResume()
        navigator.createNewRoot(Screens.MAIN_FLOW)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        BallmerPeakApplication.INSTANCE.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        BallmerPeakApplication.INSTANCE.getNavigatorHolder().removeNavigator()
        super.onPause()
    }

    private val navigator = object : BaseNavigator(this, R.id.container) {

        override fun createFlowIntent(flowKey: String, data: Any?) = getFlowIntent(flowKey, data)

        override fun createFragment(screenKey: String, data: Any?): Fragment? = when (screenKey) {
            Screens.MAIN_SCREEN -> MainFragment()
            else -> null
        }
    }

    companion object {
        fun getStartIntent(context: Context) =
                Intent(context, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                }
    }
}
