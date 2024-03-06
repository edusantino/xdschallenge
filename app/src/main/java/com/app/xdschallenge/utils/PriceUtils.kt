package com.app.xdschallenge.utils

import java.text.NumberFormat
import java.util.Locale

fun Number.toPrice(): String {
    val brazilianLocale = Locale("pt", "BR")
    val currencyFormatter = NumberFormat.getCurrencyInstance(brazilianLocale)
    return currencyFormatter.format(this)
}