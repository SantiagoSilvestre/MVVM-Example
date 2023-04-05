package com.example.exemploarquiteturamvvm.data.dao

import androidx.room.*
import com.example.exemploarquiteturamvvm.data.entities.Currency
import com.example.exemploarquiteturamvvm.data.entities.ExchangeRate

/**
 * Data Access Object (Objeto de acesso aos Datos) da entidade ExchangeRate
 */
@Dao
interface ExchangeRateDao {
    @Query("SELECT * FROM exchange_rate ORDER BY symbol ASC")
    fun getAll(): List<ExchangeRate>
    @Query("SELECT * FROM exchange_rate WHERE  timestamp > :minTime ORDER BY symbol ASC")
    fun getAllGreaterThanTimestamp(minTime: Long): List<ExchangeRate>

    @Query("SELECT * FROM exchange_rate WHERE symbol = :value LIMIT 1")
    fun findBySymbol(value: String): ExchangeRate

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exchangeRate: ExchangeRate)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(exchangeRate: Collection<ExchangeRate>)

    @Delete
    fun delete(exchangeRate: ExchangeRate)
}