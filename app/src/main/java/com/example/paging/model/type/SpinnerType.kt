package com.example.paging.model.type

/**
 * PagingExample
 * Class: SpinnerType
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */
//enum class SpinnerType {
//    ACCURACY("accuracy"),
//    RECENCY("recency")
//}


enum class SpinnerType(type: String) {
    
    ACCURACY("accuracy"), RECENCY("recency");

    private val mType: String = type
    
    fun getType(): String {
        return mType
    }

}
