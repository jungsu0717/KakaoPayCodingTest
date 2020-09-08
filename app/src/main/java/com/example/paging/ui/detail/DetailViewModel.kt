package com.example.paging.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.paging.base.BaseViewModel
import com.example.paging.common.rx.SchedulerProvider
import com.example.paging.model.data.DocumentsData
import com.example.paging.model.manager.DataManager
import javax.inject.Inject

class DetailViewModel


@Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<DetailView>(
        dataManager,
        schedulerProvider
    ) {

    val liveData = MutableLiveData<DocumentsData>()

    fun goDetailPage(url : String?){
        getNavigator()?.goDetail(url)
    }
}
