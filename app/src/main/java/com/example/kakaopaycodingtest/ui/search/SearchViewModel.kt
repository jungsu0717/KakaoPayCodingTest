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
import com.example.kakaopaycodingtest.repository.SearchPagedListRepo
import javax.inject.Inject


class SearchViewModel

@Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<SearchView>(
        dataManager,
        schedulerProvider
    ) {


    lateinit var requestData : MutableLiveData<RequestData>

    private val searchRepo = map(requestData){
        SearchPagedListRepo(
            dataManager, getCompositeDisposable()
        ).postsSearchBook(it)
    }

    var searchData : LiveData<PagedList<DocumentsData>> = switchMap(searchRepo) {it}
//
//    fun getSearchUser(keyWord: String, sort: String?, page: Int?, target: String?) {
//
//        getCompositeDisposable().add(
//            getDataManager().getBookInfo(keyWord, sort, page, target)
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe({ data ->
//
//                    searchData.postValue(data)
//
//                    setIsLoading(false)
//                    getNavigator()!!.ProgressOff()
//                }, {
//                    getNavigator()?.onError()
//                    getNavigator()?.ProgressOff()
//                })
//        )
//    }


}
