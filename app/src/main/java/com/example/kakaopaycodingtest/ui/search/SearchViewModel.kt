package com.example.kakaopaycodingtest.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.Transformations.switchMap
import androidx.paging.PagedList
import com.example.kakaopaycodingtest.base.BaseViewModel
import com.example.kakaopaycodingtest.common.rx.SchedulerProvider
import com.example.kakaopaycodingtest.model.data.DocumentsData
import com.example.kakaopaycodingtest.model.data.RequestData
import com.example.kakaopaycodingtest.model.manager.DataManager
import com.example.kakaopaycodingtest.repository.NetworkState
import com.example.kakaopaycodingtest.repository.SearchPagedListRepo
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
