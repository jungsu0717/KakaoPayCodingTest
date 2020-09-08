package com.example.paging.model.manager

import com.example.paging.model.ApiService
import io.reactivex.Maybe
import javax.inject.Inject
import javax.inject.Singleton

/**
 * PagingExample
 * Class: AppDataManager
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

@Singleton
class AppDataManager @Inject constructor(
    apiHelper: ApiService
) :
    DataManager {

    private val mApiHelper: ApiService


    init {
        mApiHelper = apiHelper
    }

    override fun getBookInfo(
        query: String,
        sort: String?,
        page: Int?,
        target: String?
    ): Maybe<com.example.paging.model.data.ResponseBody> {
        return mApiHelper.getBookInfo(query, sort, page, target)
    }


}