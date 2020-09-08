package com.example.paging.di

import android.app.Application
import android.widget.BaseAdapter
import com.example.paging.App
import com.example.paging.common.BindingUtils
import com.example.paging.di.builder.ActivityBuilder
import com.example.paging.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * PagingExample
 * Class: AppComponent
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    fun inject(app: App)

    fun inject(baseAdapter: BaseAdapter)
    //
    fun inject(bindingUtils: BindingUtils)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}