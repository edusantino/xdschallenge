package com.santino.domain.models

data class ProductDetails (
    val id:	String?,
    val title: String?,
    val imageUrl: String?,
    val rating: Float?,
    val priceList: List<Double>
)