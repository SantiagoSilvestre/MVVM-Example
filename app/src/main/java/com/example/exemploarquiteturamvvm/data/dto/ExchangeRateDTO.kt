package com.example.exemploarquiteturamvvm.data.dto

/**
 *DTO (Data Transfer Object [Objeto de transferência de dados])usada para mapear o retorno json da
 * API openexchangerates
 */
data class ExchangeRateDTO(val timestamp: Long, val base: String, val rates: Map<String, Double>)
