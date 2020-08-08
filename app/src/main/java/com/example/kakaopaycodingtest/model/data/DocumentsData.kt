package com.example.kakaopaycodingtest.model.data

import java.util.*

/**
 * KakaoPayCodingTest
 * Class: DocumentsData
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */
data class DocumentsData(

    var title: String,
    var contents: String,
    var url: String,
    var isbn: String,
    var datetime: Date,
    var authors: List<String>,
    var publisher: String,
    var translators: List<String>,
    var price: Int,
    var sale_price: Int,
    var thumbnail: String,
    var status: String
)
