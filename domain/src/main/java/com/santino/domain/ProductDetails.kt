package com.santino.domain

data class ProductDetails (
    var id:	String?,
    var name: String?,
    var imageUrl: String?,
    var rating: Float?,
    var priceList: List<Double>
)