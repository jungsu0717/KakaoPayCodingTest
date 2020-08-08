package com.example.kakaopaycodingtest

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.example.kakaopaycodingtest.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


/**
 * KakaoPayCodingTest
 * Class: Application
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */

class App : MultiDexApplication(), HasAndroidInjector {

    companion object{
        lateinit var context : Context
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector;
    }

}
