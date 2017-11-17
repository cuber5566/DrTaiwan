package com.cuber.drtaiwan.util

import android.app.Application
import android.content.res.Resources
import android.support.annotation.StringRes

class ResourceTool {

    lateinit var resource: Resources

    fun init(application: Application) {
        resource = application.resources
    }

    fun getString(@StringRes stringId: Int): String = resource.getString(stringId)


    companion object {

        private var INSTANCE: ResourceTool? = null

        @JvmStatic
        fun getInstance(): ResourceTool {
            return INSTANCE ?: ResourceTool()
                    .apply { INSTANCE = this }
        }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}