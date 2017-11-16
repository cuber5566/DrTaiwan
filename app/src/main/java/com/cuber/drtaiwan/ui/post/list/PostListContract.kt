package com.cuber.drtaiwan.ui.post.list

import com.cuber.drtaiwan.base.BasePresenterImp
import com.cuber.drtaiwan.model.SimplePost
import com.cuber.drtaiwan.ui.post.PostPresenterImp

interface PostListContract {

    interface View {

        fun onGetPostList(simplePostList: List<SimplePost>)

        fun onGetPostListError(throwable: Throwable)
    }

    interface Presenter : BasePresenterImp, PostPresenterImp {

        fun getPostList(divisionId: String)
    }
}