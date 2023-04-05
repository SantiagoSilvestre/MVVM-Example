package com.example.exemploarquiteturamvvm.data.repositories

import com.example.exemploarquiteturamvvm.data.dao.CurrencyDao
import com.example.exemploarquiteturamvvm.data.dao.ExchangeRateDao
import com.example.exemploarquiteturamvvm.data.entities.Currency
import com.example.exemploarquiteturamvvm.data.entities.ExchangeRate
import javax.inject.Inject
import javax.inject.Singleton

/**
 * repositorio para manipular os dados locais
 */

@Singleton
class LocalCurrencyRepository @Inject constructor(
    private val exchangeRateDao: ExchangeRateDao,
    private val currencyDao: CurrencyDao
) {

    fun getCurrencies(): List<Currency> {
        return currencyDao.getAll()
    }

    fun getRatesWithTimeGreaterThan(minTime: Long): List<ExchangeRate> {
        return exchangeRateDao.getAllGreaterThanTimestamp(minTime)
    }

    fun saveCurrencies(currencies: List<Currency>) {
        currencyDao.insertAll(currencies)
    }

    fun saveExchangeRates(exchageRates: List<ExchangeRate>) {
        exchangeRateDao.insertAll(exchageRates)
    }

}