package com.app.xdschallenge.utils

import java.text.DecimalFormat

class Tools {
    fun Number?.convertMoney(): String = "R$ ${DecimalFormat("##.00").format(this).replace(".", ",")}"
}