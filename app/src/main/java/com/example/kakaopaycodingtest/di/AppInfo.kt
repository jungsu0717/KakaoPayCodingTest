package com.example.kakaopaycodingtest.di

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

/**
 * KakaoPayCodingTest
 * Class: AppInfo
 * Created by yjs on 08/08/2020.
 *
 * Description:
 */

@Qualifier
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class AppInfo
