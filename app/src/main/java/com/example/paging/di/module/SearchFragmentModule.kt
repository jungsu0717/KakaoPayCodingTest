package com.example.paging.di.module

import com.example.paging.ui.search.SearchAdapter
import com.example.paging.ui.search.SearchFragment
import dagger.Module
import dagger.Provides

/**
 * PagingExample
 * Class: SearchFragmentModule
 * Created by yjs on 08/09/2020.
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