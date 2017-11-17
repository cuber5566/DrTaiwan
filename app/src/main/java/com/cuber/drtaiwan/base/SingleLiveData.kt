package com.cuber.drtaiwan.base

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.annotation.MainThread
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveData<T> {

    private val data = MutableLiveData<T>()
    private val throwable = SingleLiveEvent<Throwable>()

    fun observeSuccess(owner: LifecycleOwner, obs: Observer<T>): SingleLiveData<T> {
        data.observe(owner, obs)
        return this
    }

    fun setValue(d: T) {
        data.value = d
    }

    fun observeError(owner: LifecycleOwner, obsError: Observer<Throwable>): SingleLiveData<T> {
        throwable.observe(owner, obsError)
        return this
    }

    fun setError(t: Throwable) {
        throwable.value = t
    }
}

class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<T>) {

        super.observe(owner, Observer<T> { t ->
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(t: T?) {
        pending.set(true)
        super.setValue(t)
    }

    @MainThread
    fun call() {
        value = null
    }
}
