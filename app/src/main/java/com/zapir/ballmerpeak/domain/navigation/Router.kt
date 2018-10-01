package com.zapir.ballmerpeak.domain.navigation

class Router: NavigatorHolder {

    private var navigator: BaseNavigator? = null

    override fun removeNavigator() {
        navigator = null
    }

    override fun setNavigator(navigator: BaseNavigator) {
        this.navigator = navigator
    }

    override fun exit() {
        navigator?.back()
    }

    override fun navigateTo(key: String, data: Any?) {
        navigator?.navigateTo(key, data)
    }

    override fun startFlow(key: String, data: Any?) {
        navigator?.createFlowIntent(key, data)
    }

}
