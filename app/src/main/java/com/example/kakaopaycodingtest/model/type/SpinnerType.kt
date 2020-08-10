package com.example.kakaopaycodingtest.model.type

/**
 * KakaoPayCodingTest
 * Class: SpinnerType
 * Created by yjs on 10/08/2020.
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
