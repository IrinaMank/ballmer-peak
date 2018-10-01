package com.zapir.ballmerpeak.ui.drinking

import android.content.Context
import android.content.Intent
import com.zapir.ballmerpeak.R
import com.zapir.ballmerpeak.ui.base.BaseActivity

class DrinkingActivity: BaseActivity() {
    override val layoutRes: Int
        get() = R.layout.activity_drinking

    companion object {
        private val ARG_CENTER_X = "arg_center_x"
        private val ARG_CENTER_Y = "arg_center_y"
        fun getStartIntent(argCenterX: Long, argCenterY: Long, context: Context) =
                Intent(context, DrinkingActivity::class.java).apply {
                    putExtra(ARG_CENTER_X, argCenterX)
                    putExtra(ARG_CENTER_Y, argCenterY)
                }
    }
}