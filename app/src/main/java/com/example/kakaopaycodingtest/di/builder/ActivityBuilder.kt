package com.example.kakaopaycodingtest.di.builder

import com.example.kakaopaycodingtest.di.module.MainActivityModule
import com.example.kakaopaycodingtest.di.module.SearchFragmentModule
import com.example.kakaopaycodingtest.ui.detail.DetailFragment
import com.example.kakaopaycodingtest.ui.main.MainActivity
import com.example.kakaopaycodingtest.ui.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * KakaoPayCodingTest
 * Class: ActivityBuilder
 * Created by yjs on 07/08/2020.
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
