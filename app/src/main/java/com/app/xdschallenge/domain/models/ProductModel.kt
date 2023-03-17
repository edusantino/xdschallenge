package com.app.xdschallenge.domain.models

import java.io.*

data class ProductModel (
    var id:	String?,
    var name: String?,
    var imageUrl: String?,
    var rating: Int?,
    var priceP: Number?,
    var priceM: Number?,
    var priceG: Number?,
) : Serializable