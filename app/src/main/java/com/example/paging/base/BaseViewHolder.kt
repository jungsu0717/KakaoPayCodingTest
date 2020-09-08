package com.example.paging.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * PagingExample
 * Class: BaseViewHolder
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(data: Any)
}
