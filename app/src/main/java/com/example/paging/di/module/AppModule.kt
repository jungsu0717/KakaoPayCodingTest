package com.example.paging.di.module

import android.app.Application
import android.content.Context
import com.example.paging.BuildConfig
import com.example.paging.common.rx.AppSchedulerProvider
import com.example.paging.common.rx.SchedulerProvider
import com.example.paging.model.ApiService
import com.example.paging.model.manager.AppDataManager
import com.example.paging.model.manager.DataManager
import com.example.paging.module.ViewModelModule
import dagger.Module
import dagger.Provides
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * PagingExample
 * Class: AppModule
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

@Suppress("DEPRECATION")
@Module(includes = [ViewModelModule::class])
class AppModule {


    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val cookieManager = CookieManager()
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
        val logging = HttpLoggingInterceptor { message -> }
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.cookieJar(JavaNetCookieJar(cookieManager))
        okHttpClient.connectTimeout(10000, TimeUnit.MILLISECONDS)
        okHttpClient.readTimeout(10000, TimeUnit.MILLISECONDS)
        okHttpClient.writeTimeout(10000, TimeUnit.MILLISECONDS)
        okHttpClient.addInterceptor(logging)
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ApiService::class.java)
    }

}