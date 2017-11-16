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
import com.cuber.drtaiwan.model.SimplePost
import kotlinx.android.synthetic.main.fragment_post_list.*

class PostListFragment : BaseFragment(), PostListContract.View {

    private lateinit var presenter: PostListPresenter
    private lateinit var divisionId: String
    private lateinit var postAdapter: PostListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupArguments(arguments) {
            divisionId = getString(ARG_DIVISION_ID)
        }

        setupSaveInstanceState(savedInstanceState) {

        }

        presenter = PostListPresenter(this)
        lifecycle.addObserver(presenter)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_post_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView?.run {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            postAdapter = PostListAdapter(context, presenter)
            adapter = postAdapter
        }
        presenter.onSubscribe()
        presenter.getPostList(divisionId)
    }

    override fun onGetPostList(simplePostList: List<SimplePost>) {
        postAdapter.simplePostList = simplePostList
        postAdapter.notifyDataSetChanged()
    }

    override fun onGetPostListError(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        const val ARG_DIVISION_ID = "ARG_DIVISION_ID"

        fun newInstance(divisionId: String): PostListFragment {
            val args = Bundle()
            val fragment = PostListFragment()
            args.putString(ARG_DIVISION_ID, divisionId)
            fragment.arguments = args
            return fragment
        }
    }
}