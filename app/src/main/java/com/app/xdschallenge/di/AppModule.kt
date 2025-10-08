package com.app.xdschallenge.di

import com.santino.data.datasource.MockDataSourceImpl
import com.santino.data.datasource.OfflineDataSourceImpl
import com.santino.data.repository.FirebaseRemoteConfigImpl
import com.santino.data.repository.ProductRepositoryImpl
import com.santino.domain.repository.ProductRepository
import kotlin.getValue

object AppModule {
    val repository: ProductRepository by lazy {
        ProductRepositoryImpl(
            remoteConfig = FirebaseRemoteConfigImpl(),
            offlineDataSource = OfflineDataSourceImpl(),
            mockDataSource = MockDataSourceImpl()
        )
    }
}