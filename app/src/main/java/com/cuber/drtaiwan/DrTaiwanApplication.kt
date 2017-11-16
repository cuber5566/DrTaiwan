package com.cuber.drtaiwan

import android.app.Application

/**
 * Created by cuber on 2017/10/26.
 */

class DrTaiwanApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ResourceProvider.getInstance().init(this)
    }
}
