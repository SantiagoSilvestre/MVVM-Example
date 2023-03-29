package com.example.exemploarquiteturamvvm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exemploarquiteturamvvm.data.dao.CurrencyDao
import com.example.exemploarquiteturamvvm.data.dao.ExchangeRateDao
import com.example.exemploarquiteturamvvm.data.entities.Currency
import com.example.exemploarquiteturamvvm.data.entities.ExchangeRate


/**
 * Declaração do banco de dados do app,biblioteca usada: RoomDatabase
 */

@Database(entities = [ExchangeRate::class, Currency::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun currencyDao(): CurrencyDao
    abstract fun exchangeRateDao(): ExchangeRateDao

    companion object {

        private const val DB_NAME = "currency_db"

        // For singleton instatiation
        @Volatile
        private var instace: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instace ?: synchronized(this) {
                instace ?: buildDatabase(context).also { instace = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java, DB_NAME
            ).build()
        }

    }

}