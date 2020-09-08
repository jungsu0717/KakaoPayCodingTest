package com.example.paging.ui.detail

import com.example.paging.base.BaseView

/**
 * PagingExample
 * Class: DetailView
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

interface DetailView : BaseView {

    fun goDetail(url : String?)

    fun onError()
}
