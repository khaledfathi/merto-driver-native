package com.metro_driver.app.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.metro_driver.app.databinding.FragmentTravelsListBinding
import com.metro_driver.app.domain.entity.TravelEntity
import com.metro_driver.app.presentation.adapter.TravelsAdapter

class TravelsListFragment : Fragment() {
    private lateinit var _binding: FragmentTravelsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTravelsListBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = listOf(
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 1000000000,
                unitC = 521,
                notes = "",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "53480vjsfgjksdh",
            ),
            TravelEntity(
                travelNumber = 100,
                unitA = 438,
                unitB = 339,
                unitC = 521,
                notes = "lllllldasasdasl",
            )
        )
        _binding.travelsListRecycleView.adapter = TravelsAdapter(requireContext(), data)
    }
}