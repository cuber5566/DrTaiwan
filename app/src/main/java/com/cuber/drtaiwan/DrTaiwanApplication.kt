package com.cuber.drtaiwan

import android.app.Application

/**
 * Created by cuber on 2017/10/26.
 */

class DrTaiwanApplication : Application() {

    companion object {
        lateinit var INSTANCE: DrTaiwanApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}
