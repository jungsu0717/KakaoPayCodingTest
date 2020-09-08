package com.example.paging.model.data

/**
 * PagingExample
 * Class: RequestData
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

data class RequestData(

    var keyWord: String = "",

    var sort: String?,

    var page: Int?,

    var target: String?
)