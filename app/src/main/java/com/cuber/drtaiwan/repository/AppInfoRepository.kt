package com.cuber.drtaiwan.repository

import com.cuber.drtaiwan.model.Division
import io.reactivex.Single

class AppInfoRepository {

    fun getDivisionList(): Single<List<Division>> {
        val divisionList = ArrayList<Division>()
        divisionList.add(Division("01", "dentist", "牙醫"))
        divisionList.add(Division("02", "Division of General Medicine", "一般內科"))
        divisionList.add(Division("03", "Division of Family Medicine", "家醫科"))
        divisionList.add(Division("04", "Division of Gastroenterology", "胃腸肝膽科"))
        divisionList.add(Division("05", "Division of Cardiology", "心臟科"))
        return Single.just(divisionList)
    }

    companion object {

        private var INSTANCE: AppInfoRepository? = null

        @JvmStatic fun getInstance(): AppInfoRepository {
            return INSTANCE ?: AppInfoRepository()
                    .apply { INSTANCE = this }
        }

        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }
}