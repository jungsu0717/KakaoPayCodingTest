package com.example.paging.ui.main

import com.example.paging.base.BaseViewModel
import com.example.paging.common.rx.SchedulerProvider
import com.example.paging.model.manager.DataManager
import javax.inject.Inject

/**
 * PagingExample
 * Class: MainViewModel
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

class MainViewModel

@Inject
constructor (dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<MainView>(dataManager, schedulerProvider) {




}
