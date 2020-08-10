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

    init {
        instance = this
    }

    companion object{
        private var instance: App? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
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
