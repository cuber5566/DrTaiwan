package com.cuber.drtaiwan.ui.post.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cuber.drtaiwan.R
import com.cuber.drtaiwan.base.BaseFragment
import com.cuber.drtaiwan.extension.setupArguments
import com.cuber.drtaiwan.extension.setupSaveInstanceState
import kotlinx.android.synthetic.main.fragment_post_list.*

class PostListFragment : BaseFragment() {

    private lateinit var divisionId: String
    private lateinit var adapter:PostListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupArguments(arguments) {
            divisionId = getString(ARG_DIVISION_ID)
        }

        setupSaveInstanceState(savedInstanceState) {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_post_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView?.run {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter =
        }
    }

    companion object {

        const val ARG_DIVISION_ID = "ARG_DIVISION_ID"   2

        fun newInstance(divisionId: String): PostListFragment {
            val args = Bundle()
            val fragment = PostListFragment()
            args.putString(ARG_DIVISION_ID, divisionId)
            fragment.arguments = args
            return fragment
        }
    }
}