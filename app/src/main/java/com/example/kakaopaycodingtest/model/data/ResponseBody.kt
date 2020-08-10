package com.example.kakaopaycodingtest.model.data

import com.example.kakaopaycodingtest.model.data.DocumentsData
import com.example.kakaopaycodingtest.model.data.MetaData
import com.google.gson.annotations.SerializedName

/**
 * KakaoPayCodingTest
 * Class: ResponseBody
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */

class ResponseBody {

    @SerializedName("meta")
    val meta: MetaData? = null

    @SerializedName("documents")
    val documents: List<DocumentsData> = mutableListOf()
}