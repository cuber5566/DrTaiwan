package com.cuber.drtaiwan.ui.main

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.cuber.drtaiwan.model.Division
import com.cuber.drtaiwan.repository.AppInfoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(
        private val view: MainContract.View,
        private val appInfoRepository: AppInfoRepository = AppInfoRepository.getInstance(),
        private val compositeDisposable: CompositeDisposable = CompositeDisposable()
) : MainContract.Presenter ,LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    override fun onSubscribe() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onUnSubscribe() {
        compositeDisposable.clear()
    }

    override fun getDivision() {
        compositeDisposable.addAll(appInfoRepository.getDivisionList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { throwable: Throwable -> view.onGetDivisionError(throwable) }
                .subscribe { divisions: List<Division> -> view.onGetDivision(divisions) })
    }
}