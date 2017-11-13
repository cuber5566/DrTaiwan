package com.cuber.drtaiwan.ui.main

import com.cuber.drtaiwan.model.Division
import com.cuber.drtaiwan.repository.AppInfoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(
        private val view: MainContract.View,
        private val appInfoRepository: AppInfoRepository = AppInfoRepository.getInstance(),
        private val compositeDisposable: CompositeDisposable = CompositeDisposable()
) : MainContract.Presenter {

    override fun getDivision() {

        compositeDisposable.addAll(appInfoRepository.getDivisionList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { throwable: Throwable -> view.onGetDivisionError(throwable) }
                .subscribe { divisions: List<Division> -> view.onGetDivision(divisions) })
    }


}