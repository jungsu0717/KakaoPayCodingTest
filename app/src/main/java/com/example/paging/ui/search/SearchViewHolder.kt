package com.example.paging.ui.search

import com.example.paging.base.BaseViewHolder
import com.example.paging.databinding.ItemSearchBinding
import com.example.paging.model.data.DocumentsData

/**
 * PagingExample
 * Class: SearchViewHolder
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

class SearchViewHolder(
    private val binding : ItemSearchBinding,
    private val listener: SearchAdapter.ItemClickListener?
) : BaseViewHolder(binding.root) {

    init {
    }

    override fun onBind(data: Any) {
        if (data is DocumentsData){
            binding.root.setOnClickListener { listener?.onClick(data) }
            binding.data = data
        }
    }


}