package com.cuber.drtaiwan.ui.post.list

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.cuber.drtaiwan.repository.PostRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostListPresenter(
        private var view: PostListContract.View,
        private var postRepository: PostRepository = PostRepository.getInstance(),
        private val compositeDisposable: CompositeDisposable = CompositeDisposable()
) : PostListContract.Presenter, LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun onSubscribe() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onUnSubscribe() {
        compositeDisposable.clear()
    }

    override fun addFavorite(postId: String) {
    }

    override fun addBookmark(postId: String) {
    }

    override fun isFavorite(postId: String): Boolean {
        return true
    }

    override fun isBookmark(postId: String): Boolean {
        return true
    }

    override fun getPostList(divisionId: String) {
        compositeDisposable.add(postRepository.getSimplePostListByDivisionId(divisionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(view::onGetPostListError)
                .subscribe(view::onGetPostList))
    }
}