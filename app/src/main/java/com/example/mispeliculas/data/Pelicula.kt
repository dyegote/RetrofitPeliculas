package com.example.mispeliculas.data

import java.io.Serializable
import java.lang.StringBuilder

data class Pelicula(val titulo: String, val imagenUrl: String, val puntuacion: Double, val generos: List<String>, val descripcion: String):
    Serializable {
    fun getGenerosString(): String {
        val stringBuilder = StringBuilder()
        for (genero in generos) {
            stringBuilder.append(genero)
            stringBuilder.append(", ")
        }
        return stringBuilder.toString().removeSuffix(", ")
    }
}