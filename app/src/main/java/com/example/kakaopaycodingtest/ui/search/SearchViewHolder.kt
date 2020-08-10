package com.example.kakaopaycodingtest.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaopaycodingtest.R
import com.example.kakaopaycodingtest.base.BaseViewHolder
import com.example.kakaopaycodingtest.databinding.ItemSearchBinding
import com.example.kakaopaycodingtest.model.data.DocumentsData

/**
 * KakaoPayCodingTest
 * Class: SearchViewHolder
 * Created by yjs on 08/08/2020.
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