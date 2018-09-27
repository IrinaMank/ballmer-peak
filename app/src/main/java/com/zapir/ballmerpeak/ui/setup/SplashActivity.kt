package com.zapir.ballmerpeak.ui.setup

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.zapir.ballmerpeak.BallmerPeakApplication
import com.zapir.ballmerpeak.R
import com.zapir.ballmerpeak.ui.MainActivity
import com.zapir.ballmerpeak.ui.base.BaseActivity
import java.util.concurrent.TimeUnit

class SplashActivity: BaseActivity() {

    private val splashScreenDuration = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        scheduleSplashScreen()
    }

    private fun scheduleSplashScreen() {
        Handler().postDelayed(
                {
                    routeToAppropriatePage()
                },
                splashScreenDuration
        )
    }

    private fun routeToAppropriatePage() {
        return when (BallmerPeakApplication.preferencesManager.firstLaunch()) {
            true -> {
                BallmerPeakApplication.preferencesManager.registerLaunch()
                startActivity(Intent(this@SplashActivity, InitialActivity::class.java))

            }
            false -> {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))

            }
        }
    }


    //private fun routeToAppropriatePage() {

//                        {
//                            if (it == true) {
//                                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
//                            } else {
//                                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
//                            }
//                        },
//                        {
//                            ExceptionHandler.defaultHandler(this).handleException(it, this)
//                        }
//                )
//        finish()
   // }

}
