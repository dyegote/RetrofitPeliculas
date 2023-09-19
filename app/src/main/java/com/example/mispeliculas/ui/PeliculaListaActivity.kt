package com.example.mispeliculas.ui

import android.content.Intent
import android.os.Bundle
import androidx.core.widget.NestedScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.mispeliculas.R
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mispeliculas.data.Pelicula

class PeliculaListaActivity : AppCompatActivity() {

    private val viewModel: PeliculaListaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula_lista)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = title

        val peliculasObserver = Observer<List<Pelicula>> { peliculas ->
            setupRecyclerView(findViewById(R.id.item_list), peliculas)
        }

        viewModel.peliculas.observe(this, peliculasObserver)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, peliculas: List<Pelicula>) {
        recyclerView.adapter = SimpleFilmRecyclerViewAdapter(this, peliculas)
    }

    class SimpleFilmRecyclerViewAdapter(private val parentActivity: PeliculaListaActivity,
                                        private val values: List<Pelicula>) :
            RecyclerView.Adapter<SimpleFilmRecyclerViewAdapter.ViewHolder>() {

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
                val item = v.tag as Pelicula

                val intent = Intent(v.context, PeliculaDetalleActivity::class.java).apply {
                    putExtra(PeliculaDetalleFragment.ARG_ITEM, item)
                }
                v.context.startActivity(intent)

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.pelicula_lista_contenido, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val pelicula = values[position]
            holder.idView.text = pelicula.puntuacion.toString()
            holder.contentView.text = pelicula.titulo

            with(holder.itemView) {
                tag = pelicula
                setOnClickListener(onClickListener)
            }
        }

        override fun getItemCount() = values.size
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val idView: TextView = view.findViewById(R.id.id_text)
            val contentView: TextView = view.findViewById(R.id.content)
        }
    }
}