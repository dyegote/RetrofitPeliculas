package com.example.mispeliculas.ui

import androidx.lifecycle.ViewModel
import com.example.mispeliculas.data.Pelicula

class PeliculaListaViewModel: ViewModel() {
    val peliculas: List<Pelicula> = listOf(
        Pelicula("Rogue", "https://image.tmdb.org/t/p/w500/uOw5JD8IlD546feZ6oxbIjvN66P.jpg", 5.9, listOf("Acción"), "Rogue es la historia de una pequeña unidad mercenaria de soldados que han sido contratados por el gobernador de un país africano para rescatar a su hija que ha sido secuestrada por una organización terrorista."),
        Pelicula("Train To Busan 2: Peninsula", "https://image.tmdb.org/t/p/w500/ew1lAU8yV66JbivBU1Zh4Wj4pOB.jpg", 7.2, listOf("Acción", "Terror", "Suspense"), "Después de que la infección que se extendió hace 4 años, solo algunas partes de Corea del Sur permanecen resguardadas, aunque la Península de Busan es la única parte en donde pueden buscar refugio los coreanos, muchos aún mantienen la esperanza de ser rescatados por ayuda internacional."),
        Pelicula("Proyecto Power", "https://image.tmdb.org/t/p/w500/goz3AVYFjLNKuC787HowcxWM6cZ.jpg", 6.7, listOf("Acción", "Crimen", "Ciencia ficción"), "Comienza a correrse la voz por las calles de Nueva Orleans de una misteriosa pastilla nueva que le confiere superpoderes únicos a cada persona que la consume. ¿La trampa? No sabes qué puede pasar hasta que la tomas... Algunos adquieren una piel a prueba de balas, invisibilidad y fuerza sobrehumana, mientras que otros padecen una reacción más letal. Con la llegada de la pastilla, la tasa de delitos de la ciudad escala a niveles peligrosos, por lo que un policía local (Joseph Gordon-Levitt) se une a una traficante de drogas adolescente (Dominique Fishback) y a un exsoldado motivado por un plan de venganza secreto (Jamie Foxx) para enfrentar con poder al poder. Tanto es así, que se arriesgan a tomar la pastilla con el objetivo de encontrar y detener al grupo responsable de su elaboración."),
        Pelicula("After: en mil pedazos", "https://image.tmdb.org/t/p/w500/3k4TvOWxJZyeMJtbjHQELKIEhpb.jpg", 7.2, listOf("Drama", "Romance"), "Ha pasado el tiempo, y Hardin todavía no se sabe si es realmente el chico profundo y reflexivo del que Tessa se enamoró, o ha sido un extraño todo este tiempo. Ella quiere alejarse, pero no es tan fácil. Tessa se ha centrado en sus estudios y comienza a trabajar como becaria en Vance Publishing. Allí conoce a Trevor, un nuevo y atractivo compañero de trabajo que es exactamente el tipo de persona con la que debería estar. Pero Hardin sabe que cometió un error, posiblemente el más grande de su vida y quiere corregir sus errores y vencer a sus demonios... Secuela de la película 'After'."),
        Pelicula("Archive", "https://image.tmdb.org/t/p/w500/eDnHgozW8vfOaLHzfpHluf1GZCW.jpg", 5.9, listOf("Ciencia ficción"), "2038: George Almore está trabajando en una verdadera IA equivalente a la humana. Su último prototipo está casi listo. Esta fase sensible también es la más arriesgada. Especialmente porque tiene un objetivo que debe ocultarse a toda costa: reunirse con su esposa muerta")
    )
}