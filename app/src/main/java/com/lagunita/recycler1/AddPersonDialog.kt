package com.lagunita.recycler1

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lagunita.recycler1.model.Person

class AddPersonDialog : DialogFragment() {

    private lateinit var nameEditText: EditText
    private lateinit var edadEditText: EditText
    private lateinit var aboutEditText: EditText

    override fun onStart() {
        super.onStart()
        nameEditText = dialog?.findViewById(R.id.editTextNamePersona) as EditText
        edadEditText = dialog?.findViewById(R.id.editTextEdadPersona) as EditText
        aboutEditText = dialog?.findViewById(R.id.editTextAboutPersona) as EditText
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext())
            .setTitle("Agregar persona")
            .setView(R.layout.fragment_add_person)
            .setPositiveButton("Confirm") { dialog, which ->
                val name = nameEditText.text.toString()
                val age = Integer.parseInt(edadEditText.text.toString())
                val about = aboutEditText.text.toString()

                val model: MainViewModel by activityViewModels()

                model.addPerson(Person(name, age, about))
            }
            .setNegativeButton("Cancel") {dialog, which ->

            }
            .show()
    }
}