package com.example.kakaopaycodingtest.ui.main

import com.example.kakaopaycodingtest.base.BaseViewModel
import com.example.kakaopaycodingtest.common.rx.SchedulerProvider
import com.example.kakaopaycodingtest.model.manager.DataManager
import javax.inject.Inject

/**
 * KakaoPayCodingTest
 * Class: MainViewModel
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */

class MainViewModel

@Inject
constructor (dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<MainView>(dataManager, schedulerProvider) {




}
