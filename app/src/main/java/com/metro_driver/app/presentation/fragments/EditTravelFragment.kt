package com.metro_driver.app.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.metro_driver.app.R
import com.metro_driver.app.databinding.FragmentEditTravelBinding
import com.metro_driver.app.presentation.viewmodel.MainActivityViewModel
import com.metro_driver.core.general.debugPrint

class EditTravelFragment : Fragment() {
    private lateinit var _binding: FragmentEditTravelBinding
    private lateinit var _viewModel: MainActivityViewModel
    private lateinit var _activity: FragmentActivity
    private lateinit var _context: Context
    private lateinit var _args: EditTravelFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditTravelBinding.inflate(inflater, container, false)
        _viewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _activity = requireActivity()
        _context = requireContext()
        init()
    }

    private fun init() {
        getArgs()
        eventBackButtonClick()
        eventSaveButtonClick()
        eventDeleteButtonClick()
    }

    private fun getArgs() {
        val args: EditTravelFragmentArgs by navArgs()
        _args = args
        _binding.travelNumberEditText.setText(args.travelNumber)
        _binding.unitAEditText.setText(args.unitA)
        _binding.unitBEditText.setText(args.unitB)
        _binding.unitCEditText.setText(args.unitC)
        _binding.noteEditText.setText(args.notes)
    }

    /*##### Events #####*/

    private fun eventBackButtonClick() {
        _binding.backImageButton.setOnClickListener {
            _activity.supportFragmentManager.popBackStack()
        }
    }

    private fun eventSaveButtonClick() {
        _binding.saveImageButton.setOnClickListener {
            _viewModel.updateTravel(
                context = _context,
                id = _args.id.toString(),
                date = _args.date!!,
                time = _args.time!!,
                travel = _binding.travelNumberEditText.text.toString(),
                unitA = _binding.unitAEditText.text.toString(),
                unitB = _binding.unitBEditText.text.toString(),
                unitC = _binding.unitCEditText.text.toString(),
                notes = _binding.noteEditText.text.toString(),
                onSuccess = { updatingCount ->
                    _activity.supportFragmentManager.popBackStack()
                },
                onFailure = { }
            )
        }
    }

    private fun eventDeleteButtonClick() {
        _binding.deleteImageButton.setOnClickListener {
            ConfirmDialog(
                title = _activity.resources.getString(R.string.confirm_delete_travel_title) ,
                message = _activity.resources.getString(R.string.confirm_delete_travel_message) ,
                onYesPressed = {
                    _viewModel.deleteTravel(
                        context = _context,
                        id = _args.id.toString(),
                        onSuccess = {
                            _activity.supportFragmentManager.popBackStack()
                            debugPrint("Success deleted")
                        },
                        onFailure = { error ->
                            debugPrint("error on delete : $error")
                        })
                }
            ).show(_activity.supportFragmentManager, ConfirmDialog.DELETE_TRAVEL)
        }
    }
}