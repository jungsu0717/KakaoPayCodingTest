package com.example.paging.common.rx

import io.reactivex.Scheduler

/**
 * PagingExample
 * Class: SchedulerProvider
 * Created by yjs on 08/09/2020.
 *
 * Description:
 */

interface SchedulerProvider {
    fun computation(): Scheduler?
    fun io(): Scheduler?
    fun ui(): Scheduler?
}
