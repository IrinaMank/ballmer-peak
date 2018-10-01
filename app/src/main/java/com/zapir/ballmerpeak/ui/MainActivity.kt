package com.zapir.ballmerpeak.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.zapir.ballmerpeak.R
import com.zapir.ballmerpeak.Screens
import com.zapir.ballmerpeak.domain.navigation.BaseNavigator
import com.zapir.ballmerpeak.presentation.launch.LaunchPresenter
import com.zapir.ballmerpeak.presentation.launch.LaunchView
import com.zapir.ballmerpeak.ui.MainFragment
import com.zapir.ballmerpeak.ui.base.BaseActivity
import com.zapir.ballmerpeak.ui.setup.InitialFragment

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
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MainFragment())
                .commitNow()
    }

    companion object {
        fun getStartIntent(context: Context) =
                Intent(context, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                }
    }
}
