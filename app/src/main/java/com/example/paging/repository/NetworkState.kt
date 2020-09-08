package com.example.paging.repository

import com.example.paging.App
import com.example.paging.R

/**
 * PagingExample
 * Class: NetworkState
 * Created by yjs on 08/09/2020.
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
