package com.example.kakaopaycodingtest.ui.detail

import com.example.kakaopaycodingtest.base.BaseView

/**
 * KakaoPayCodingTest
 * Class: DetailView
 * Created by yjs on 10/08/2020.
 *
 * Description:
 */

interface DetailView : BaseView {

    fun goDetail(url : String?)

    fun onError()
}
