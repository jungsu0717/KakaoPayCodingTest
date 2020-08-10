package com.example.kakaopaycodingtest.model

import com.example.kakaopaycodingtest.R
import com.example.kakaopaycodingtest.common.CommonDefine
import com.example.kakaopaycodingtest.model.data.ResponseBody
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


/**
 * KakaoPayCodingTest
 * Class: ApiService
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */




interface ApiService {


    @Headers("Authorization: KakaoAK deaf578bd2a2685d649a30cf7b6baa11")
    @GET("/v3/search/book")
    fun getBookInfo(
        @Query("query") query : String,
        @Query("sort") sort : String?,
        @Query("page") page : Int?,
        @Query("target") target : String?
    ) : Maybe<ResponseBody>

}