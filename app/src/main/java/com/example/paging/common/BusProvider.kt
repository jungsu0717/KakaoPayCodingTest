package com.example.paging.common

import com.squareup.otto.Bus

/**
 * PagingExample
 * Class: BusProvider
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

object BusProvider {

    private val BUS = Bus()

    fun getInstance(): Bus {
        return BUS
    }
}
