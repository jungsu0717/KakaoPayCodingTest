package com.example.paging.di.builder

import com.example.paging.di.module.MainActivityModule
import com.example.paging.di.module.SearchFragmentModule
import com.example.paging.ui.detail.DetailFragment
import com.example.paging.ui.main.MainActivity
import com.example.paging.ui.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * PagingExample
 * Class: ActivityBuilder
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

@Module
abstract class ActivityBuilder {

    /**
     * 메인
     */
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [SearchFragmentModule::class])
    abstract fun bindSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun bindDetailFragment(): DetailFragment

}
