package com.example.mispeliculas.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mispeliculas.data.Genero
import com.example.mispeliculas.data.Pelicula

@Dao
interface GeneroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun guarar(pelicula: Pelicula)

    @Query("SELECT * FROM genero")
    fun cargar(): LiveData<Genero>


}