package com.cuber.drtaiwan.ui.main

import com.cuber.drtaiwan.model.Division
import com.cuber.drtaiwan.repository.AppInfoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(private val mView: MainContract.View, private val mAppInfoRepository: AppInfoRepository) : MainContract.Presenter {

    private val mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onSubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUnSubscribe() {
        mCompositeDisposable.dispose()
        mCompositeDisposable.clear()
    }

    override fun getDivision() {
        mCompositeDisposable.add(mAppInfoRepository.getDivisionList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { throwable: Throwable -> mView.onGetDivisionError(throwable) }
                .subscribe { divisionList: List<Division> -> mView.onGetDivision(divisionList) }
        )
    }
}