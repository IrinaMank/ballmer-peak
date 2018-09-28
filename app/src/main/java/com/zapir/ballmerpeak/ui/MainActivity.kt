package com.zapir.ballmerpeak

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.zapir.ballmerpeak.presentation.MainPresenter
import com.zapir.ballmerpeak.presentation.MainView
import com.zapir.ballmerpeak.ui.MainFragment

class MainActivity : BaseActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter {
        return MainPresenter()
    }

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initMainScreen() {
        super.onResume()
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MainFragment())
                .commitNow()
    }
}
