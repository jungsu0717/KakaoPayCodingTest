package com.example.paging.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.Transformations.switchMap
import androidx.paging.PagedList
import com.example.paging.base.BaseViewModel
import com.example.paging.common.rx.SchedulerProvider
import com.example.paging.model.data.DocumentsData
import com.example.paging.model.data.RequestData
import com.example.paging.model.manager.DataManager
import com.example.paging.repository.NetworkState
import com.example.paging.repository.SearchPagedListRepo
import javax.inject.Inject


class SearchViewModel

@Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<SearchView>(
        dataManager,
        schedulerProvider
    ) {

    private val repository = SearchPagedListRepo(dataManager, getCompositeDisposable())

    val requestData = MutableLiveData<RequestData>()

    private val searchRepo = map(requestData){
        repository.postsSearchBook(it)
    }


    var searchData : LiveData<PagedList<DocumentsData>> = switchMap(searchRepo) {
        it.pagedList
    }

    var networkState : LiveData<NetworkState> = switchMap(searchRepo) {it.networkState}


    fun listIsEmpty(): Boolean {
        return searchData?.value?.isEmpty() ?: true
    }

    fun refresh() {
        searchRepo.value?.refresh?.invoke()
    }


}
