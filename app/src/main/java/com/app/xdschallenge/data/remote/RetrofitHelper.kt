package com.app.xdschallenge.data.remote

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.Schedulers.io
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    companion object {
        fun <S> createCall(serviceClass: Class<S>): S {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://p3teufi0k9.execute-api.us-east-1.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))

            val httpClient = OkHttpClient.Builder()
            retrofit.client(httpClient.build())
            return  retrofit.build().create(serviceClass)
        }
    }
}