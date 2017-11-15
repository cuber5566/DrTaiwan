package com.cuber.drtaiwan.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.cuber.drtaiwan.model.Division
import com.cuber.drtaiwan.ui.post.list.PostListFragment
import com.cuber.drtaiwan.widget.SmartFragmentStatePagerAdapter

/**
 * Created by cuber on 2017/11/15.
 */
class MainPagerAdapter(fm: FragmentManager) : SmartFragmentStatePagerAdapter(fm) {

    var divisionList: List<Division>? = null

    override fun getPageTitle(position: Int): CharSequence? = divisionList?.get(position)!!.displayName

    override fun getItem(position: Int): Fragment = PostListFragment.newInstance(divisionList?.get(position)!!.id)

    override fun getCount(): Int = if (divisionList == null) 0 else divisionList!!.size
}