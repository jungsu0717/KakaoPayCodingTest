---
title: "Kotlin 예제"
date: 2020-09-08
categories: Android Kotlin
---

# 목차

* 스크린샷
* 개발환경
* apk 다운로드
* 외부 라이브러리
* 적용기술

# 스크린샷
![image](https://user-images.githubusercontent.com/6903839/89779398-39ae2b80-db4a-11ea-81b9-0585162f398e.png)

# 개발환경

### 사용언어
* Kotlin

### 개발 IDE
* Android Studio

### 아키택처
* AAC 적용

### SDK 버전
~~~kotlin
minSdkVersion 16
targetSdkVersion 29
~~~


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

### 의존성 주입
* Dagger2 적용

### Android Jetpack
* Architecture : Lifecycle, LiveData, ViewModel, Paging, Navigator, DataBinding 적용
* Foundation : Multidex, KTX, AppCompat 적용

### 페이징 처리 / 당겨서 새로고침
* PagingList, SwipeRefreshLayout 적용

### Rx 코드 적용

### 이미지 처리
* Glide 적용

### 통신
* Retrofit2 적용
