package com.example.paging.repository

import androidx.lifecycle.Transformations
import androidx.paging.Config
import androidx.paging.toLiveData
import com.example.paging.model.data.DocumentsData
import com.example.paging.model.data.RequestData
import com.example.paging.model.manager.DataManager
import com.example.paging.repository.SearchDataSource.Companion.PER_PAGE_SIZE
import io.reactivex.disposables.CompositeDisposable

/**
 * PagingExample
 * Class: SearchPagedListRepo
 * Created by yjs on 08/09/2020.
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

