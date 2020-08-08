package com.example.kakaopaycodingtest.repository

import androidx.paging.PageKeyedDataSource
import com.example.kakaopaycodingtest.model.data.DocumentsData
import com.example.kakaopaycodingtest.model.data.RequestData
import com.example.kakaopaycodingtest.model.manager.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * KakaoPayCodingTest
 * Class: SearchDataSource
 * Created by yjs on 08/08/2020.
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

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, DocumentsData>
    ) {


        compositeDisposable.add(
            dataManager.getBookInfo(
                requestData.keyWord,
                requestData.sort,
                FIRST_PAGE,
                requestData.target
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->

                    callback.onResult(data.documents, null, FIRST_PAGE + 1)
                }, {

                })
        )

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DocumentsData>) {

        compositeDisposable.add(
            dataManager.getBookInfo(
                requestData.keyWord,
                requestData.sort,
                params.key,
                requestData.target
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->

                    callback.onResult(data.documents, params.key + 1)
                }, {

                })
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DocumentsData>) {
        TODO("Not yet implemented")
    }

}