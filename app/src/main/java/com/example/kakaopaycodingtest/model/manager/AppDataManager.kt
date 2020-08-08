package com.example.kakaopaycodingtest.model.manager

import com.example.kakaopaycodingtest.model.ApiService
import io.reactivex.Maybe
import okhttp3.ResponseBody
import javax.inject.Inject
import javax.inject.Singleton

/**
 * KakaoPayCodingTest
 * Class: AppDataManager
 * Created by yjs on 07/08/2020.
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
    ): Maybe<com.example.kakaopaycodingtest.model.data.ResponseBody> {
        return mApiHelper.getBookInfo(query, sort, page, target)
    }


}