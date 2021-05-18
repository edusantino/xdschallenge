package com.app.xdschallenge.data.models

import java.io.*

data class Pizza (
    var id:	String?,
    var name: String?,
    var imageUrl: String?,
    var rating: Int?,
    var priceP: Number?,
    var priceM: Number?,
    var priceG: Number?,
) : Serializable