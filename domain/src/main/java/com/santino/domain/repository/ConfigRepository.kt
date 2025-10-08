package com.santino.domain.repository

interface ConfigRepository {
    suspend fun fetchConfig(): Boolean
    fun getString(key: String): String
    fun getBoolean(key: String): Boolean
    fun getFeatureFlag(feature: String): Boolean
}