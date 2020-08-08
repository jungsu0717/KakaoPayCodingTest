package com.example.kakaopaycodingtest.di.module

import android.content.Context
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kakaopaycodingtest.R
import com.example.kakaopaycodingtest.model.data.DocumentsData
import com.example.kakaopaycodingtest.ui.search.SearchAdapter
import com.example.kakaopaycodingtest.ui.search.SearchFragment
import dagger.Module
import dagger.Provides

/**
 * KakaoPayCodingTest
 * Class: SearchFragmentModule
 * Created by yjs on 08/08/2020.
 *
 * Description:
 */

@Module
class SearchFragmentModule {

    @Provides
    fun providePagingListAdapter(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @Provides
    fun providePagingListAdapter(fragment: SearchFragment): SearchAdapter {
        return SearchAdapter()
    }

}