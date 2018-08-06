package com.zapir.ballmerpeak.domain.bottomNavigationApi

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class BottomBarPagerAdapter(mgr: FragmentManager) : FragmentPagerAdapter(mgr) {

    private val PAGE_COUNT = 3

    override fun getItem(position: Int): Fragment {
        return when (position) {
            //0 -> SearchFragmentHolder.newInstance()
            //1 -> MapFragmentHolder.newInstance()
            //2 -> ProfileFragmentHolder.newInstance()
            else -> Fragment()
        }
    }

    override fun getCount(): Int = PAGE_COUNT

}