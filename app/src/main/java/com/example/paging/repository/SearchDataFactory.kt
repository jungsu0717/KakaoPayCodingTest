package com.example.paging.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.paging.model.data.DocumentsData
import com.example.paging.model.data.RequestData
import com.example.paging.model.manager.DataManager
import io.reactivex.disposables.CompositeDisposable

/**
 * PagingExample
 * Class: SearchDataFactory
 * Created by yjs on 08/09/2020.
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
