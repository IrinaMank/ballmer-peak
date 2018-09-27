package com.zapir.ballmerpeak.ui.calculation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zapir.ballmerpeak.R
import com.zapir.ballmerpeak.ui.base.BaseFragment

class CalculationFragment: BaseFragment() {

    companion object {

        fun newInstance() = CalculationFragment()

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_calculation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}
