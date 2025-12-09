package com.example.zeromeal

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

class TambahFragment : Fragment() {
    private lateinit var etName: EditText
    private lateinit var etExpiry: EditText
    private lateinit var btnSave: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tambah, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etName = view.findViewById(R.id.et_ingredient_name)
        etExpiry = view.findViewById(R.id.et_expiry_date)
        btnSave = view.findViewById(R.id.btn_save)

        etExpiry.setOnClickListener {
            showDatePicker()
        }

        btnSave.setOnClickListener {
            saveIngredient()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            requireContext(),
            { _, year, month, day ->
                etExpiry.setText("$day/${month + 1}/$year")
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun saveIngredient() {
        val name = etName.text.toString()
        val expiry = etExpiry.text.toString()

        if (name.isEmpty() || expiry.isEmpty()) {
            Toast.makeText(context, "Mohon isi semua field", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(context, "Bahan berhasil ditambahkan", Toast.LENGTH_SHORT).show()
        etName.text.clear()
        etExpiry.text.clear()
    }
}