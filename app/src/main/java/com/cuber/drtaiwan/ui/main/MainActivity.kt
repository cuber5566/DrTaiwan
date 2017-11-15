package com.cuber.drtaiwan.ui.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.view.Menu
import android.view.MenuItem
import com.cuber.drtaiwan.R
import com.cuber.drtaiwan.base.BaseActivity
import com.cuber.drtaiwan.extension.setupActionBar
import com.cuber.drtaiwan.extension.setupActionBarDrawerToggle
import com.cuber.drtaiwan.model.Division
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),
        MainContract.View,
        NavigationView.OnNavigationItemSelectedListener {


    private lateinit var presenter: MainPresenter
    private lateinit var pagerAdapter: MainPagerAdapter

    override fun onCreateData(savedInstanceState: Bundle?) {
        presenter = MainPresenter(this)
        lifecycle.addObserver(presenter)
    }

    override fun onCreateView(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)

        setupActionBar(R.id.toolbar) {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        setupActionBarDrawerToggle(R.id.drawerLayout, R.id.toolbar)

        navigationView.setNavigationItemSelectedListener(this)

        tabLayout.setupWithViewPager(viewPager)

        pagerAdapter = MainPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
    }

    override fun onCreateAction(savedInstanceState: Bundle?) {
        presenter.getDivision()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.toolbar_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onGetDivision(divisionList: List<Division>) {
        pagerAdapter.divisionList = divisionList
        pagerAdapter.notifyDataSetChanged()
    }

    override fun onGetDivisionError(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
