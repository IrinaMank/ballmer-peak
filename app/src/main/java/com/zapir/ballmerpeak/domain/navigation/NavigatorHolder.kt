package com.zapir.ballmerpeak.domain.navigation

interface NavigatorHolder {

    fun setNavigator(navigator: BaseNavigator)
    fun removeNavigator()
    fun startFlow(key: String, data: Any? = null)
    fun navigateTo(key: String, data: Any? = null)
    fun exit()
}