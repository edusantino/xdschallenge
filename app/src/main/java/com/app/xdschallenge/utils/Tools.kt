package com.app.xdschallenge.utils

import java.text.DecimalFormat

class Tools {

    fun converterMoney(valr: Number?) : String {
        var df = DecimalFormat("##.00")
        var newVal : String = "R$ " + df.format(valr).replace(".", ",")
        return newVal
    }
}