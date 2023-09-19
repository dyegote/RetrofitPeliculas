package com.example.mispeliculas.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.mispeliculas.MisPeliculasApplication
import com.example.mispeliculas.api.RetrofitServiceBuilder
import com.example.mispeliculas.api.TheMovieDBService
import com.example.mispeliculas.data.Generos
import com.example.mispeliculas.data.Pelicula
import com.example.mispeliculas.data.PeliculasActuales
import com.example.mispeliculas.database.GeneroDao
import com.example.mispeliculas.database.PeliculaDao
import com.example.mispeliculas.database.PeliculaDatabase
import retrofit2.Call
import retrofit2.Response

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val API_KEY = "20ee8ae83f77251b6a6d9d725c0573a6"
private const val IMAGE_URL_ROOT = "https://image.tmdb.org/t/p/w500/"
object PeliculasRepository {

    private var database: PeliculaDatabase? = null
    private var peliculasDao: PeliculaDao? = null
    private var generosDao: GeneroDao? = null

    private val peliculasService: TheMovieDBService = RetrofitServiceBuilder(BASE_URL)
        .buildServices(TheMovieDBService::class.java)

    private val peliculasCompletasLiveData = MutableLiveData<List<Pelicula>>()

    init {
        val context = MisPeliculasApplication.appContext
        context?.let {
            database = Room.databaseBuilder(it, PeliculaDatabase::class.java, "DatabasePeliculas").build()
            peliculasDao = database?.peliculaDao()
            generosDao = database?.generoDao()
        }
    }
    fun obtenerPeliculasActuales(): LiveData<List<Pelicula>> {
        val call = peliculasService.obtenerPeliculasActuales(API_KEY, "es", 1, "ES")
        call.enqueue(object: retrofit2.Callback<PeliculasActuales> {
            override fun onResponse(
                call: Call<PeliculasActuales>,
                response: Response<PeliculasActuales>
            ) {
                if(response.isSuccessful) {
                    val peliculas = response.body()?.peliculas ?: listOf()
                    completarInformacion(peliculas)
                }
            }

            override fun onFailure(call: Call<PeliculasActuales>, t: Throwable) {

            }

        })
        return peliculasDao?.cargarPeliculas() ?: MutableLiveData<List<Pelicula>>()
    }

    private fun completarInformacion(peliculas: List<Pelicula>) {
        val call = peliculasService.obtenerListaDeGeneros(API_KEY, "es")
        call.enqueue(object: retrofit2.Callback<Generos> {
            override fun onResponse(call: Call<Generos>, response: Response<Generos>) {
                if(response.isSuccessful) {
                    val generos = response.body()?.generes
                    val mapaDeGeneros = generos?.associateBy({it.id}, {it.name})
                    mapaDeGeneros?.let { mapa ->
                        peliculas.forEach { pelicula ->
                            pelicula.generos = pelicula.generosIDs.map { mapa[it] ?: "" }
                            pelicula.imagenUrl =  IMAGE_URL_ROOT + pelicula.posterPath
                        }
                        Thread {
                            peliculasDao?.insetarPeliculas(peliculas)
                        }.start()
                    }
                }
            }

            override fun onFailure(call: Call<Generos>, t: Throwable) {

            }

        })

    }
}