package com.example.kakaopaycodingtest.common

import com.squareup.otto.Bus

/**
 * KakaoPayCodingTest
 * Class: BusProvider
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */

object BusProvider {

    private val BUS = Bus()

    fun getInstance(): Bus {
        return BUS
    }
}
