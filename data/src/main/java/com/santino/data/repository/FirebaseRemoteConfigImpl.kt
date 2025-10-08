package com.santino.data.repository

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.santino.domain.repository.ConfigRepository
import kotlinx.coroutines.tasks.await

class FirebaseRemoteConfigImpl : ConfigRepository {
    private val remoteConfig = FirebaseRemoteConfig.getInstance()

    override suspend fun fetchConfig(): Boolean {
        return try {
            remoteConfig.fetchAndActivate().await()
        } catch (e: Exception) {
            false
        }
    }

    override fun getString(key: String): String = remoteConfig.getString(key)

    override fun getBoolean(key: String): Boolean = remoteConfig.getBoolean(key)

    override fun getFeatureFlag(feature: String): Boolean =
        remoteConfig.getBoolean("feature_$feature")
}