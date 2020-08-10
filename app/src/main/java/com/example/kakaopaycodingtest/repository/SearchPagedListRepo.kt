package com.example.kakaopaycodingtest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.Config
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.example.kakaopaycodingtest.model.data.DocumentsData
import com.example.kakaopaycodingtest.model.data.RequestData
import com.example.kakaopaycodingtest.model.manager.DataManager
import com.example.kakaopaycodingtest.repository.SearchDataSource.Companion.PER_PAGE_SIZE
import io.reactivex.disposables.CompositeDisposable

/**
 * KakaoPayCodingTest
 * Class: SearchPagedListRepo
 * Created by yjs on 09/08/2020.
 *
 * Description:
 */


class SearchPagedListRepo(
    private val dataManager: DataManager,
    private val compositeDisposable: CompositeDisposable
) {

    fun postsSearchBook(requestData: RequestData): DataRepository<DocumentsData> {
        val sourceFactory = SearchDataFactory(dataManager, compositeDisposable, requestData)
        val livePagedList = sourceFactory.toLiveData(
            config = Config(
                pageSize = PER_PAGE_SIZE,
                enablePlaceholders = false,
                prefetchDistance = 4
            )
        )
        return DataRepository(
            pagedList = livePagedList,
            networkState = Transformations.switchMap(sourceFactory.searchLiveData) {
                it.initLoad
            },
            refresh = {
                sourceFactory.searchLiveData.value?.invalidate()
            }
        )

    }



}

