package com.example.kakaopaycodingtest.common.rx

import io.reactivex.Scheduler

/**
 * KakaoPayCodingTest
 * Class: SchedulerProvider
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */

interface SchedulerProvider {
    fun computation(): Scheduler?
    fun io(): Scheduler?
    fun ui(): Scheduler?
}
