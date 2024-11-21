package com.metro_driver.app.presentation.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.metro_driver.app.R

class ConfirmDialog(val title: String, val message: String, val onYesPressed: () -> Unit) :
    DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.fragment_confirm_dialog, null)

            //text on layout
            view.findViewById<TextView>(R.id.title_text_view).text = title
            view.findViewById<TextView>(R.id.message_text_view).text = message
            // --- events
            view.findViewById<Button>(R.id.ok_btn).setOnClickListener {
                dialog?.cancel()
                onYesPressed()
            }
            view.findViewById<Button>(R.id.cancel_btn).setOnClickListener { dialog?.cancel() }

            builder.setView(view).create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    companion object {
        const val DELETE_TRAVEL = "delete travel"
    }
}