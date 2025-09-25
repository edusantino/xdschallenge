package com.app.xdschallenge.domain.models

import java.io.*

data class ProductDetails (
    var id:	String?,
    var name: String?,
    var imageUrl: String?,
    var rating: Int?,
    var list: List<Double>
) : Serializable