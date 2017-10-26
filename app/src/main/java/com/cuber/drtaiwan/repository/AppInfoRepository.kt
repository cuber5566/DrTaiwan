package com.cuber.drtaiwan.repository

import com.cuber.drtaiwan.model.Division
import io.reactivex.Single

/**
 * Created by cuber on 2017/10/26.
 */
object AppInfoRepository {

    fun getDivisionList(): Single<List<Division>> {
        val divisionList = ArrayList<Division>()
        divisionList.add(Division("01", "dentist", "牙醫"))
        divisionList.add(Division("02", "Division of General Medicine", "一般內科"))
        divisionList.add(Division("03", "Division of Family Medicine", "家醫科"))
        divisionList.add(Division("04", "Division of Gastroenterology", "胃腸肝膽科"))
        divisionList.add(Division("05", "Division of Cardiology", "心臟科"))
        return Single.just(divisionList)
    }
}