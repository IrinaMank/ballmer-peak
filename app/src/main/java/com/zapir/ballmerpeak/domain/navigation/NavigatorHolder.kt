package com.zapir.ballmerpeak.domain.navigation

interface NavigatorHolder {

    fun setNavigator(navigator: BaseNavigator)
    fun removeNavigator()
}