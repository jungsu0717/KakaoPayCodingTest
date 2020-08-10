---
title: "카카오페이 코딩 테스트"
date: 2020-08-10
categories: Android Kotlin
---

# 목차

* 스크린샷
* 개발환경
* apk 다운로드
* 외부 라이브러리
* 적용기술


# 스크린샷
<img width="360" alt="main" src="https://user-images.githubusercontent.com/6903839/89766246-d49b0b80-db32-11ea-83c2-673d077d484e.png">
<img width="359" alt="main_search" src="https://user-images.githubusercontent.com/6903839/89766255-d664cf00-db32-11ea-862f-220a9d64559e.png">
<img width="358" alt="main_detail" src="https://user-images.githubusercontent.com/6903839/89766261-d82e9280-db32-11ea-84c5-d3462974b0f0.png">

# 개발환경

1) 사용언어
* Kotlin

2) 개발 IDE
* Android Studio

3) 아키택처
* AAC 적용

4) SDK 버전
~~~kotlin
minSdkVersion 16
targetSdkVersion 29
~~~

# apk 다운로드
링크 : https://drive.google.com/file/d/1xJc9nE5K_o_J0SsAtb-Tw_o45o0Y9sOO/view?usp=sharing


# 외부 라이브러리
~~~kotlin
    // dependencies

    // Reactive X
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation "io.reactivex.rxjava2:rxjava:2.2.10"
    implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'

    // RxBinding
    implementation "com.jakewharton.rxbinding2:rxbinding-appcompat-v7-kotlin:$rxBindingVersion"

    // Retrofit + Gson Parser
    implementation "com.squareup.retrofit2:retrofit:2.5.0"
    implementation "com.squareup.retrofit2:converter-gson:2.5.0"
    implementation "com.squareup.retrofit2:adapter-rxjava2:2.5.0"
    implementation "com.squareup.retrofit2:converter-moshi:2.3.0"

    implementation "com.squareup.okhttp3:logging-interceptor:3.11.0"
    implementation "com.squareup.okhttp3:okhttp-urlconnection:3.8.1"

    // glide - https://github.com/bumptech/glide
    implementation 'com.github.bumptech.glide:glide:4.8.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.8.0'
    implementation 'jp.wasabeef:glide-transformations:3.3.0'

    // Optional -- Mockito framework
    testImplementation 'org.mockito:mockito-core:1.10.19'

    // Bus
    implementation 'com.squareup:otto:1.3.8'
~~~  

# 적용기술

1) 의존성 주입
  * Dagger2 적용

2) Android Jetpack
  * Architecture : Lifecycle, LiveData, ViewModel, Paging, Navigator, DataBinding 적용
  * Foundation : Multidex, KTX, AppCompat 적용

3) 페이징 처리 / 당겨서 새로고침
  * PagingList, SwipeRefreshLayout 적용

4) Rx 코드 적용

5) 이미지 처리
  * Glide 적용

* 6) 통신
  - Retrofit2 적용