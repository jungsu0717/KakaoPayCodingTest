package com.example.kakaopaycodingtest.repository

import com.example.kakaopaycodingtest.App
import com.example.kakaopaycodingtest.R

/**
 * KakaoPayCodingTest
 * Class: NetworkState
 * Created by yjs on 09/08/2020.
 *
 * Description:
 */
class NetworkState(val status: Status, val message: Message) {

    enum class Status {
        LOADING,
        LOADED,
        FAILED
    }

    class Message(var msg: String)

    companion object {
        private val context by lazy {
            App.applicationContext()
        }
        val LOADING = NetworkState(Status.LOADING,
            Message(context.getString(R.string.network_loading))
        )
        val LOADED = NetworkState(Status.LOADED,
            Message(context.getString(R.string.network_loaded))
        )
        val ERROR = NetworkState(Status.FAILED,
            Message(context.getString(R.string.network_error))
        )
    }
}
