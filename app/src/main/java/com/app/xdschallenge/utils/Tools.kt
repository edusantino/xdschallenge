package com.app.xdschallenge.utils

import java.text.NumberFormat
import java.util.*

object Tools {
    fun printPrice(value: Number?): String =
        NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(value)
}