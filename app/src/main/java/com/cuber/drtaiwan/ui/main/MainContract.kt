package com.cuber.drtaiwan.ui.main

import com.cuber.drtaiwan.base.BasePresenter
import com.cuber.drtaiwan.model.Division

/**
 * Created by cuber on 2017/10/26.
 */
interface MainContract {

    interface View {

        fun onGetDivision(divisionList: List<Division>)

        fun onGetDivisionError(throwable: Throwable)
    }

    interface Presenter :BasePresenter{

        fun getDivision()

    }
}