package com.app.xdschallenge.data.model

import com.app.xdschallenge.domain.models.ProductDetails

fun ProductDto.toDomain() = ProductDetails(
        id = id,
        name = name,
        imageUrl = imageUrl,
        rating = rating,
        priceList = priceList
)