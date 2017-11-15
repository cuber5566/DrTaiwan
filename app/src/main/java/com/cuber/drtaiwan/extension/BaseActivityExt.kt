package com.cuber.drtaiwan.extension

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import com.cuber.drtaiwan.R


fun AppCompatActivity.setupSaveInstanceState(bundle: Bundle?, action: Bundle.() -> Unit) {
    bundle?.run(action)
}

fun AppCompatActivity.setupActionBar(@IdRes toolbarId: Int, action: ActionBar.() -> Unit) {
    setSupportActionBar(findViewById(toolbarId))
    supportActionBar?.run {
        action()
    }
}

fun AppCompatActivity.setupActionBarDrawerToggle(@IdRes drawerLayoutId: Int, @IdRes toolbarId: Int) {

    val drawerLayout = findViewById<DrawerLayout>(drawerLayoutId)
    val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            findViewById(toolbarId),
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)

    drawerLayout.addDrawerListener(toggle)
    toggle.syncState()
}