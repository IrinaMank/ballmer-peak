package com.zapir.ballmerpeak.presentation.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.zapir.ballmerpeak.BallmerPeakApplication
import com.zapir.ballmerpeak.Screens
import com.zapir.ballmerpeak.presentation.launch.LaunchView

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    private val router = BallmerPeakApplication.INSTANCE.getRouter()

    fun onCalculateClick() {
        router.navigateTo(Screens.AUTH_SCREEN)
    }
}