package com.cuber.drtaiwan.ui.main

import com.cuber.drtaiwan.base.BasePresenterImp
import com.cuber.drtaiwan.model.Division

interface MainContract {

    interface View {

        fun onGetDivision(divisionList: List<Division>)

        fun onGetDivisionError(throwable: Throwable)
    }

    interface Presenter : BasePresenterImp {

        fun getDivision()
    }
}