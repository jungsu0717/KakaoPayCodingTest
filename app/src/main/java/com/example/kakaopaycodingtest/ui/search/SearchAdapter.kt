package com.example.kakaopaycodingtest.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.kakaopaycodingtest.databinding.ItemSearchBinding
import com.example.kakaopaycodingtest.model.data.DocumentsData

/**
 * KakaoPayCodingTest
 * Class: SearchAdapter
 * Created by yjs on 08/08/2020.
 *
 * Description:
 */

class SearchAdapter : PagedListAdapter<DocumentsData, SearchViewHolder>(SearchDiffUtils()) {

    var listener: ItemClickListener? = null

    interface ItemClickListener {
        fun onClick(id: DocumentsData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ItemSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), listener
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }



    class SearchDiffUtils : DiffUtil.ItemCallback<DocumentsData>() {
        override fun areItemsTheSame(oldItem: DocumentsData, newItem: DocumentsData): Boolean {
            return oldItem == oldItem
        }

        override fun areContentsTheSame(oldItem: DocumentsData, newItem: DocumentsData): Boolean {
            return oldItem == newItem
        }
    }

}