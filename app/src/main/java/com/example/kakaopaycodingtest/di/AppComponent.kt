package com.example.kakaopaycodingtest.di

import android.app.Application
import android.widget.BaseAdapter
import com.example.kakaopaycodingtest.App
import com.example.kakaopaycodingtest.common.BindingUtils
import com.example.kakaopaycodingtest.di.builder.ActivityBuilder
import com.example.kakaopaycodingtest.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * KakaoPayCodingTest
 * Class: AppComponent
 * Created by yjs on 08/08/2020.
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