package com.example.exemploarquiteturamvvm.data.exceptions


/**
 * Está é uma excessão genérica usada para lidar com erros inesperados
 */
class GenericException : Exception(message) {

    companion object {
        const val message = "An unexpected error has occurred, please contact costumer support"
    }

}