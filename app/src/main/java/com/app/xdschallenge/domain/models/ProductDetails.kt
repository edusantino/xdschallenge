package com.app.xdschallenge.domain.models

data class ProductDetails (
    var id:	String?,
    var name: String?,
    var imageUrl: String?,
    var rating: Float?,
    var priceList: List<Double>
)