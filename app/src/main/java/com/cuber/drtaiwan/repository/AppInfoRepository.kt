package com.cuber.drtaiwan.repository

import com.cuber.drtaiwan.model.Division
import io.reactivex.Single

class AppInfoRepository {

    fun getDivisionList(): Single<List<Division>> {
        val divisionList = ArrayList<Division>()
        divisionList.add(Division("00", "top", "熱門文章"))
        divisionList.add(Division("01", "newest", "最新文章"))
        divisionList.add(Division("02", "collection", "收藏文章"))
        divisionList.add(Division("04", "forum", "綜合討論區"))
        divisionList.add(Division("04", "normal", "不分科"))
        divisionList.add(Division("05", "dentist", "牙科"))
        divisionList.add(Division("06", "Division of General Medicine", "一般內科"))
        divisionList.add(Division("07", "Division of Family Medicine", "家醫科"))
        divisionList.add(Division("08", "Division of Gastroenterology", "胃腸肝膽科"))
        divisionList.add(Division("09", "Division of Cardiology", "心臟科"))
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