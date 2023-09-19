package com.example.mispeliculas.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mispeliculas.data.Pelicula

@Dao
interface PeliculaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetarPelicula(pelicula: Pelicula)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetarPeliculas(peliculas: List<Pelicula>)

    @Update
    fun actualizarPelicula(pelicula: Pelicula)

    @Delete
    fun borrarPelicula(pelicula: Pelicula)

    @Query("SELECT * FROM pelicula")
    fun cargarPeliculas(): LiveData<List<Pelicula>>

    @Query("SELECT * FROM pelicula WHERE puntuacion > :puntuacionMinima")
    fun cargarPeliculas(puntuacionMinima: Double): LiveData<List<Pelicula>>


}