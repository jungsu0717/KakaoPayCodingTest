package com.example.kakaopaycodingtest.ui.detail

import androidx.lifecycle.MutableLiveData
import com.example.kakaopaycodingtest.base.BaseViewModel
import com.example.kakaopaycodingtest.common.rx.SchedulerProvider
import com.example.kakaopaycodingtest.model.data.DocumentsData
import com.example.kakaopaycodingtest.model.manager.DataManager
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
