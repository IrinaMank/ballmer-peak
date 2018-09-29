package com.zapir.ballmerpeak.presentation.launch

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class LaunchPresenter: MvpPresenter<LaunchView>() {

    override fun onFirstViewAttach() {
        viewState.initMainScreen()
    }
}