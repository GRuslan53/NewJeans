package com.amsdevelops.filmssearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newjeans.databinding.FilmItemBinding

//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(private val filmBinding: FilmItemBinding) :
    RecyclerView.ViewHolder(filmBinding.root) {
    //в этом методе кладем данные из Film в наши View
    fun bind(film: Film) {
        // Устанавливаем заголовок
        filmBinding.title.text = film.title
        // Устанавливаем постер
        filmBinding.poster.setImageResource(film.poster)
        // Устанавливаем описание
        filmBinding.description.text = film.description
    }

//в этом методе мы привязываем наш ViewHolder и передаем ихда "надутую" верстку нашего фильма

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        filmBinding = FilmItemBinding.inflate(layoutInflater, parent, false)
        return FilmViewHolder(filmBinding)
    }
}