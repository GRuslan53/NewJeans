package com.amsdevelops.filmssearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newjeans.R

class DetailsFragment : Fragment() {
    private var _binding: DetailsFragment? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailsFragment.inflate(inflater, container, false)
        val view = binding.root
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFilmsDetails()
    }

    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        val film = arguments?.get("film") as Film

        //Устанавливаем заголовок
        binding.details_toolbar.title = film.title
        //Устанавливаем картинку
        binding.details_poster.setImageResource(film.poster)
        //Устанавливаем описание
        binding.details_description.text = film.description
    }
}