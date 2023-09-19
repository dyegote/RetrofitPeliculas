package com.example.mispeliculas.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mispeliculas.data.Converters
import com.example.mispeliculas.data.Genero
import com.example.mispeliculas.data.Pelicula

@Database(
    entities = [Pelicula::class, Genero::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class PeliculaDatabase: RoomDatabase() {

    abstract fun peliculaDao(): PeliculaDao

    abstract fun generoDao(): GeneroDao
}