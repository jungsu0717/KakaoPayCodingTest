package com.example.kakaopaycodingtest.model.data

import androidx.lifecycle.MutableLiveData

/**
 * KakaoPayCodingTest
 * Class: RequestData
 * Created by yjs on 08/08/2020.
 *
 * Description:
 */

data class RequestData (

    var keyWord : String,

    var sort : String?,

    var page : Int?,

    var target : String?
)