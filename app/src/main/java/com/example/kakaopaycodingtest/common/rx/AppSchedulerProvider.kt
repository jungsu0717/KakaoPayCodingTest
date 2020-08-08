package com.example.kakaopaycodingtest.common.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * KakaoPayCodingTest
 * Class: AppSchedulerProvider
 * Created by yjs on 07/08/2020.
 *
 * Description:
 */

class AppSchedulerProvider : SchedulerProvider {
    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
