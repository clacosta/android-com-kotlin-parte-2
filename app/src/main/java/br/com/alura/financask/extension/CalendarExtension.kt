package br.com.alura.financask.extension

import java.text.SimpleDateFormat
import java.util.Calendar

fun Calendar.formataParaBrasileiro(): String? {
    val formatoBrasileiro = "dd/MM/yyyy"
    val format = SimpleDateFormat(formatoBrasileiro)
    val time = this.time
    return format.format(time)
}