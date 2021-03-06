package com.example.gcserevisionapp.ui.home

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.gcserevisionapp.PrefConfig
import com.example.gcserevisionapp.R
import com.example.gcserevisionapp.databinding.FragmentHomeBinding
import com.example.gcserevisionapp.ui.home.HomeViewModel
import org.joda.time.*
import java.util.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel
    private var binding: FragmentHomeBinding? = null
    private val TAG = "HomeFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        val c = Calendar.getInstance()

        val dateBtn = binding!!.dateChangeBtn
        val dateLeftText = binding!!.remainingDaysView
        dateBtn.setOnClickListener { pickDate(dateBtn, dateLeftText, c) }
        updateTextViews(dateBtn, dateLeftText, c)

        val progressBtn = binding!!.continueRevision
        progressBtn.setOnClickListener {
            val fragmentId = PrefConfig.Reader.readInt(view.context)
            view.findNavController().navigate(fragmentId)
        }
    }

    private fun pickDate(subject1: Button, subject2: TextView, c: Calendar) {
        val date = DatePickerDialog.OnDateSetListener { _, y, m, dayOfMonth ->
            saveDate(y, m, dayOfMonth)
            updateTextViews(subject1, subject2, c)
        }

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            date,
            c.get(Calendar.YEAR),
            c.get(Calendar.MONTH),
            c.get(Calendar.DAY_OF_MONTH)
        )

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        val year = sharedPref.getInt(getString(R.string.exam_date_year), c.get(Calendar.YEAR))
        val month = sharedPref.getInt(getString(R.string.exam_date_month), c.get(Calendar.MONTH))
        val day = sharedPref.getInt(getString(R.string.exam_date_day), c.get(Calendar.DAY_OF_MONTH))

        datePickerDialog.updateDate(year, month, day)
        datePickerDialog.show()
    }

    @SuppressLint("SetTextI18n")
    private fun updateTextViews(subject1: TextView, subject2: TextView, c: Calendar) {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        val year = sharedPref.getInt(getString(R.string.exam_date_year), c.get(Calendar.YEAR))
        val month = sharedPref.getInt(getString(R.string.exam_date_month), c.get(Calendar.MONTH))
        val day = sharedPref.getInt(getString(R.string.exam_date_day), c.get(Calendar.DAY_OF_MONTH))
        subject1.text = "${month + 1}/${day}/${year}"

        val dob: String = "${year}-${month + 1}-${day}"
        val diff = Days.daysBetween(DateTime().withTimeAtStartOfDay(), DateTime.parse(dob)).days

        subject2.text = diff.toString()
    }

    private fun saveDate(year: Int, month: Int, day: Int) {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putInt(getString(R.string.exam_date_year), year)
            putInt(getString(R.string.exam_date_month), month)
            putInt(getString(R.string.exam_date_day), day)
            apply()
        }
    }
}
