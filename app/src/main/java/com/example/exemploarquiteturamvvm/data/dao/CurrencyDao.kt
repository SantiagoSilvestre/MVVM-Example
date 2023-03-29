package com.example.exemploarquiteturamvvm.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.exemploarquiteturamvvm.data.entities.Currency

/**
 * Data Access Object (Objeto Acesso ao Dados) para a entidade Currency
 */
@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currency ORDER BY symbol ASC")
    fun getAll(): List<Currency>

    @Query("SELECT * FROM currency WHERE symbol = :value LIMIT 1")
    fun findBySymbol(value: String): Currency

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(currency: Currency)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(currencies: Collection<Currency>)

    @Delete
    fun delete(currency: Currency)

}