package com.example.mispeliculas.data

import com.google.gson.annotations.SerializedName

data class PeliculasActuales(@SerializedName("result") val peliculas: List<Pelicula>)