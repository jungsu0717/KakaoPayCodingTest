package com.example.paging.model.data

import com.google.gson.annotations.SerializedName

/**
 * PagingExample
 * Class: ResponseBody
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

class ResponseBody {

    @SerializedName("meta")
    val meta: MetaData? = null

    @SerializedName("documents")
    val documents: List<DocumentsData> = mutableListOf()
}