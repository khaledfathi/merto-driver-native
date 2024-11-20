package com.metro_driver.app.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.metro_driver.app.databinding.FragmentAddTravelBinding
import com.metro_driver.app.presentation.viewmodel.MainActivityViewModel
import com.metro_driver.core.general.debugPrint


class AddTravelFragment : Fragment() {
    private lateinit var _viewModel: MainActivityViewModel
    private lateinit var _binding: FragmentAddTravelBinding
    //
    private lateinit var _activity:FragmentActivity
    private lateinit var _context:Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddTravelBinding.inflate(inflater, container, false)
        _viewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _activity = requireActivity()
        _context = requireContext()
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        //events
        eventSaveButtonClick()
        eventBackButtonClick()
        eventSaveButtonClick()
    }

    private fun eventSaveButtonClick() {
        _binding.saveImageButton.setOnClickListener {
            _viewModel.addTravel(
                context = _context,
                travel = _binding.travelNumberEditText.text.toString(),
                unitA = _binding.unitAEditText.text.toString(),
                unitB = _binding.unitBEditText.text.toString(),
                unitC = _binding.unitCEditText.text.toString(),
                notes = _binding.noteEditText.text.toString(),
                onSuccess = {
                    _activity.supportFragmentManager.popBackStack()
                },
                onFailure = {
                }
            )
        }
    }

    private fun eventBackButtonClick (){
        _binding.backImageButton.setOnClickListener {
            _activity.supportFragmentManager.popBackStack()
        }
    }

}