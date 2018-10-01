package com.zapir.ballmerpeak.domain.navigation

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.zapir.ballmerpeak.ui.base.BaseActivity
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import java.util.*

public abstract class BaseNavigator(private val activity: BaseActivity,
                                    private val containerId: Int) {
    private val stack = LinkedList<String>()
    private var fragmentManager = activity.supportFragmentManager

    init {
        val stackSize = fragmentManager.backStackEntryCount
        for (i in 0 until stackSize) {
            stack.add(fragmentManager.getBackStackEntryAt(i).name)
        }
    }

    fun back() {
        if (stack.isEmpty()) {
            activity.finish()
        } else {
            fragmentManager.popBackStack()
            stack.pop()
        }
    }

    fun navigateTo(key: String, data: Any?) {
        val fragment = createFragment(key, data)

        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction
                .replace(containerId, fragment)
                .addToBackStack(key)
                .commit()
        stack.add(key)
    }

    abstract fun createFragment(screenKey: String, data: Any? = null): Fragment?

    open fun createFlowIntent(flowKey: String, data: Any?): Intent? = null

}