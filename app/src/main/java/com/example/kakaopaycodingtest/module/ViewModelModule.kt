package com.example.kakaopaycodingtest.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kakaopaycodingtest.ui.detail.DetailViewModel
import com.example.kakaopaycodingtest.ui.main.MainViewModel
import com.example.kakaopaycodingtest.ui.search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * KakaoPayCodingTest
 * Class: ViewModelModule
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */


@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    internal abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    internal abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel
}
