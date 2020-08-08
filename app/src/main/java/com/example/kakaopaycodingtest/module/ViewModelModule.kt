package com.example.kakaopaycodingtest.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kakaopaycodingtest.ui.main.MainViewModel
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

//    @Binds
//    @IntoMap
//    @ViewModelKey(LocalFragmentViewModel::class)
//    internal abstract fun bindLocalFragmentViewModel(localFragmentViewModel: LocalFragmentViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(SearchGitHubViewModel::class)
//    internal abstract fun bindPageViewModel(pageViewModel: SearchGitHubViewModel): ViewModel

    //Add more ViewModels here
}
