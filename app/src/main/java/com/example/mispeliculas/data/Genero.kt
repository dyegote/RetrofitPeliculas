package com.example.mispeliculas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Genero(
    @PrimaryKey val id: Int,
    val name: String
    )