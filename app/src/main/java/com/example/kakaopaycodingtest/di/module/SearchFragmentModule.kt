package com.example.kakaopaycodingtest.di.module

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
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
    fun providePagingListAdapter(fragment: SearchFragment): SearchAdapter {
        return SearchAdapter()
    }

}