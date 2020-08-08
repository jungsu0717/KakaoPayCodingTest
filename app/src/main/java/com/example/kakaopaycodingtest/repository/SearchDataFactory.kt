package com.example.kakaopaycodingtest.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.kakaopaycodingtest.model.data.DocumentsData
import com.example.kakaopaycodingtest.model.data.RequestData
import com.example.kakaopaycodingtest.model.manager.DataManager
import io.reactivex.disposables.CompositeDisposable

/**
 * KakaoPayCodingTest
 * Class: SearchDataFactory
 * Created by yjs on 08/08/2020.
 *
 * Description:
 */
class SearchDataFactory(
    private val dataManager: DataManager,
    private val compositeDisposable: CompositeDisposable,
    private val requestData: RequestData
) : DataSource.Factory<Int, DocumentsData>() {

    val searchLiveData by lazy {
        MutableLiveData<SearchDataSource>()
    }

    override fun create(): DataSource<Int, DocumentsData> {
        return SearchDataSource(
            dataManager,
            compositeDisposable,
            requestData
        ).also {
            searchLiveData.postValue(it)
        }
    }
}
