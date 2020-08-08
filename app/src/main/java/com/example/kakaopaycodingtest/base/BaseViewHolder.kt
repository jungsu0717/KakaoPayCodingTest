package com.example.kakaopaycodingtest.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * KakaoPayCodingTest
 * Class: BaseViewHolder
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(data: Any)
}
