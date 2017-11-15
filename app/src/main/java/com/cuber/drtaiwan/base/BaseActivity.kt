package com.cuber.drtaiwan.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateData(savedInstanceState)
        onCreateView(savedInstanceState)
        onCreateAction(savedInstanceState)
    }

    abstract fun onCreateData(savedInstanceState: Bundle?)

    abstract fun onCreateView(savedInstanceState: Bundle?)

    abstract fun onCreateAction(savedInstanceState: Bundle?)
}