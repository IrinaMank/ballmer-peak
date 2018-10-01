package com.zapir.ballmerpeak.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.zapir.ballmerpeak.R
import com.zapir.ballmerpeak.presentation.main.MainPresenter
import com.zapir.ballmerpeak.presentation.main.MainView
import com.zapir.ballmerpeak.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*
import android.view.ViewAnimationUtils
import android.animation.Animator
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth



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

    override fun revealAnimation() {
        val x = calculateButton.left + calculateButton.width
        val y = calculateButton.top + calculateButton.height

//        val startRadius = 0
//        val endRadius = Math.hypot(fragment_main_layout.width.toDouble(), fragment_main_layout
//                .height.toDouble())

//        val anim = ViewAnimationUtils.createCircularReveal(fragment_main_layout, x, y, startRadius.toFloat(),
//                endRadius.toFloat())
//
//        layoutButtons.setVisibility(View.VISIBLE)
//        anim.start()
    }
}