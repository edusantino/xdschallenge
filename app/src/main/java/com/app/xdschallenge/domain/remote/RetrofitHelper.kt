package com.app.xdschallenge.domain.remote

import com.app.xdschallenge.utils.Const
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    companion object {
        fun <S> createCall(serviceClass: Class<S>): S {
            val retrofit = Retrofit.Builder()
                .baseUrl(Const.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))

            val httpClient = OkHttpClient.Builder()
            retrofit.client(httpClient.build())
            return  retrofit.build().create(serviceClass)
        }
    }
}