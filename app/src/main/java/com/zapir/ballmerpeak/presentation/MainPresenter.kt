package com.zapir.ballmerpeak.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        viewState.initMainScreen()
    }
}