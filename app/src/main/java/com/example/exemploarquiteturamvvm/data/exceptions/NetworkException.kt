package com.example.exemploarquiteturamvvm.data.exceptions

/**
 * Está é uma excessão customizada usada para lidar com erros da network
 */
class NetworkException : Exception(message) {

    companion object {
        const val message = "An error occurred while retrieving data from the server"
    }

}