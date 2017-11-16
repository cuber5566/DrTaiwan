package com.cuber.drtaiwan

import android.app.Application
import android.content.res.Resources
import android.support.annotation.StringRes

class ResourceProvider {

    lateinit var resource: Resources

    fun init(application: Application) {
        resource = application.resources
    }

    fun getString(@StringRes stringId: Int): String = resource.getString(stringId)


    companion object {

        private var INSTANCE: ResourceProvider? = null

        @JvmStatic
        fun getInstance(): ResourceProvider {
            return INSTANCE ?: ResourceProvider()
                    .apply { INSTANCE = this }
        }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}