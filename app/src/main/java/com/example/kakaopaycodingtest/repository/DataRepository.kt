package com.example.kakaopaycodingtest.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

/**
 * KakaoPayCodingTest
 * Class: DataRepository
 * Created by yjs on 09/08/2020.
 *
 * Description:
 */

data class DataRepository<T>(
    val pagedList: LiveData<PagedList<T>>,
    val networkState: LiveData<NetworkState>,
    val refresh: () -> Unit
)