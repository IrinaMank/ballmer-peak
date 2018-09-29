package com.zapir.ballmerpeak.domain.navigation

class Router: NavigatorHolder {

    private var navigator: BaseNavigator? = null

    override fun removeNavigator() {
        navigator = null
    }

    override fun setNavigator(navigator: BaseNavigator) {
        this.navigator = navigator
    }

    fun exit() {
        navigator?.back()
    }

    fun navigateTo(key: String, data: Any? = null) {
        navigator?.navigateTo(key, data)
    }

}