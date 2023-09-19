package com.example.mispeliculas.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.lang.StringBuilder

data class Pelicula(
    @SerializedName("title") val titulo: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("vote_average") val puntuacion: Double,
    @SerializedName("genere_ids") val generosIDs: List<Int>,
    @SerializedName("overview") val descripcion: String
    ):
    Serializable {

    var imagenUrl: String = ""
    var generos: List<String> = mutableListOf()

    fun getGenerosString(): String {
        val stringBuilder = StringBuilder()
        for (genero in generos) {
            stringBuilder.append(genero)
            stringBuilder.append(", ")
        }
        return stringBuilder.toString().removeSuffix(", ")
    }
}