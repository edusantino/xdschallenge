package com.app.xdschallenge.data.model

import com.google.gson.annotations.SerializedName

data class ProductDto (
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("imageUrl") val imageUrl: String?,
    @SerializedName("rating") val rating: Float?,
    @SerializedName("priceList") val priceList: List<Double>
)