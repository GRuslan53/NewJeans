package com.example.newjeans

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.amsdevelops.filmssearch.Film
import com.amsdevelops.filmssearch.FilmListRecyclerAdapter
import com.example.newjeans.databinding.ActivityMainBinding

class HomeFragment : Fragment() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase = listOf(
        Film(
            "Léon: The Professional",
            R.drawable.leon_the_professional,
            "12-year-old Mathilda is reluctantly taken in by Léon, a professional assassin, after her family is murdered. An unusual relationship forms as she becomes his protégée and learns the assassin's trade."
        ),
        Film(
            "Forrest Gump",
            R.drawable.forrest_gump,
            "The history of the United States from the 1950s to the '70s unfolds from the perspective of an Alabama man with an IQ of 75, who yearns to be reunited with his childhood sweetheart"
        ),
        Film(
            "Blade Runner 2049",
            R.drawable.blade_runner_2049,
            "Young Blade Runner K's discovery of a long-buried secret leads him to track down former Blade Runner Rick Deckard, who's been missing for thirty years."
        ),
        Film(
            "No Country for Old Men",
            R.drawable.no_country_for_old_men,
            "Violence and mayhem ensue after a hunter stumbles upon the aftermath of a drug deal gone wrong and over two million dollars in cash near the Rio Grande."
        ),
        Film(
            "Fight Club",
            R.drawable.fight_club,
            "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more."
        ),
        Film(
            "The Wolf of Wall Street",
            R.drawable.the_wolf_of_wall_street,
            "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government."
        ),
        Film(
            "Mr. Robot",
            R.drawable.mr_robot,
            "Elliot, a brilliant but unstable cyber-security engineer and vigilante hacker, becomes a key figure in a complex game of global chaos when he and his shadowy allies try to take down the corrupt corporation his company is paid to protect."
        ),
        Film(
            "Harry Potter and the Sorcerer's Stone",
            R.drawable.harry_potter,
            "An orphaned boy enrolls in a school of wizardry, where he learns the truth about himself, his family and the terrible evil that haunts the magical world."
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //находим наш RV
        filmsAdapter =
            FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
        //Присваиваем адаптер
        adapter = filmsAdapter
        //Присвои layoutmanager
        layoutManager = LinearLayoutManager(requireContext())
        //Применяем декоратор для отступов
        val decorator = TopSpacingItemDecoration(8)
        addItemDecoration(decorator)
    }
    //Кладем нашу БД в RV
    filmsAdapter.addItems(filmsDataBase)
}
}

}