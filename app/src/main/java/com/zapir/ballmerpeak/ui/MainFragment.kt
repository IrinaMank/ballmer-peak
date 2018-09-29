package com.zapir.ballmerpeak.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.zapir.ballmerpeak.R
import com.zapir.ballmerpeak.presentation.main.MainPresenter
import com.zapir.ballmerpeak.presentation.main.MainView
import com.zapir.ballmerpeak.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: BaseFragment(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter {
        return MainPresenter()
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        calculateButton.setOnClickListener {
            presenter.onCalculateClick()
        }
    }

    override fun showPercentage(percent: Double) {
        percentTextView.text = percent.toString()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_main

}