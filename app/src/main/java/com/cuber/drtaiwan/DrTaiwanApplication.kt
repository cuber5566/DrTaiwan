package com.cuber.drtaiwan

import android.app.Application
import com.cuber.drtaiwan.util.ResourceTool
import com.cuber.drtaiwan.util.PreferencesTool

class DrTaiwanApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ResourceTool.getInstance().init(this)
        PreferencesTool.getInstance().init(this)
    }
}
