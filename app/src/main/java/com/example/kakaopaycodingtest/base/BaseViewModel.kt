package com.example.kakaopaycodingtest.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.example.kakaopaycodingtest.common.rx.SchedulerProvider
import com.example.kakaopaycodingtest.model.manager.DataManager
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * KakaoPayCodingTest
 * Class: BaseViewModel
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */

abstract class BaseViewModel<N>(mDataManager : DataManager , schedulerProvider: SchedulerProvider) : ViewModel() {

    private val mIsLoading = ObservableBoolean()

    private val mDataManager: DataManager = mDataManager

    private val mSchedulerProvider: SchedulerProvider = schedulerProvider

    private val mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    private var mNavigator: WeakReference<N>? = null

    override fun onCleared() {
        mCompositeDisposable.dispose()
        super.onCleared()
    }

    fun getCompositeDisposable(): CompositeDisposable {
        return mCompositeDisposable
    }

//    fun getDataManager(): DataManager {
//        return mDataManager
//    }

    fun getIsLoading(): ObservableBoolean {
        return mIsLoading
    }

    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }

    fun getNavigator(): N? {
        return mNavigator!!.get()
    }

    fun getWeakNavigator(): WeakReference<N>? {
        return mNavigator
    }

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }

    fun getSchedulerProvider(): SchedulerProvider {
        return mSchedulerProvider
    }

    fun getDataManager(): DataManager {
        return mDataManager
    }

}
