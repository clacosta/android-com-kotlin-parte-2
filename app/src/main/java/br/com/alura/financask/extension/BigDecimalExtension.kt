package br.com.alura.financask.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.formataParaBrasileiro(): String? {
    val formatoBrasileiro: NumberFormat = DecimalFormat.getCurrencyInstance(
        Locale("pt", "br")
    )
    return formatoBrasileiro.format(this).replace("-R$", "R$ -")
}