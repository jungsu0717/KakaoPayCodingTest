package com.example.paging.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

/**
 * PagingExample
 * Class: DataRepository
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

data class DataRepository<T>(
    val pagedList: LiveData<PagedList<T>>,
    val networkState: LiveData<NetworkState>,
    val refresh: () -> Unit
)