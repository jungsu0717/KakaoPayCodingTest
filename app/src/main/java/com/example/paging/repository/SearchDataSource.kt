package com.example.paging.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.paging.BuildConfig
import com.example.paging.model.data.DocumentsData
import com.example.paging.model.data.RequestData
import com.example.paging.model.manager.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * PagingExample
 * Class: SearchDataSource
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */
class SearchDataSource(
    private val dataManager: DataManager,
    private val compositeDisposable: CompositeDisposable,
    private val requestData: RequestData
) : PageKeyedDataSource<Int, DocumentsData>() {

    companion object {
        private val TAG = SearchDataSource::class.java.simpleName
        private const val FIRST_PAGE = 1
        const val PER_PAGE_SIZE = 50
    }

    val initLoad by lazy {
        MutableLiveData<NetworkState>()
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, DocumentsData>
    ) {
        initLoad.postValue(NetworkState.LOADING)
        compositeDisposable.add(
            dataManager.getBookInfo(
                requestData.keyWord,
                requestData.sort,
                FIRST_PAGE,
                requestData.target
            )
                .map { response -> response.documents }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    callback.onResult(data, null, FIRST_PAGE + 1)
                    initLoad.postValue(NetworkState.LOADED)
                }, {
                    initLoad.postValue(NetworkState.ERROR)
                    it.message?.let { message ->
                        Log.e(TAG, message)
                    }
                })
        )

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DocumentsData>) {

        initLoad.postValue(NetworkState.LOADING)
        compositeDisposable.add(
            dataManager.getBookInfo(
                requestData.keyWord,
                requestData.sort,
                params.key,
                requestData.target
            )
                .map { response -> response.documents }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    callback.onResult(data, params.key + 1)
                    initLoad.postValue(NetworkState.LOADED)
                }, {
                    initLoad.postValue(NetworkState.ERROR)
                    it.message?.let { message ->
                        Log.e(TAG, message)
                    }
                })
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DocumentsData>) {
        TODO("Not yet implemented")
    }

}