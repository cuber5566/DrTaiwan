package com.cuber.drtaiwan.extension

import android.os.Bundle
import com.cuber.drtaiwan.base.BaseFragment

fun BaseFragment.setupArguments(bundle: Bundle?, action: Bundle.() -> Unit) {
    bundle?.run(action)
}

fun BaseFragment.setupSaveInstanceState(bundle: Bundle?, action: Bundle.() -> Unit) {
    bundle?.run(action)
}