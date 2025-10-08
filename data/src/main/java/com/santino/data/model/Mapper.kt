package com.santino.data.model

import com.santino.domain.models.ProductDetails

fun ProductDto.toDomain() = ProductDetails(
        id = id,
        title = title,
        imageUrl = imageUrl,
        rating = rating,
        priceList = priceList
)