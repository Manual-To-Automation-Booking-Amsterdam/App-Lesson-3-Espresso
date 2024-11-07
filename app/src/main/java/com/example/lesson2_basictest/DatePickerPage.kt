package com.example.lesson2_basictest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.lesson2_basictest.databinding.DatePickerBinding
import java.text.SimpleDateFormat
import java.util.Date

class DatePickerPage : Fragment() {
    private var binding: DatePickerBinding? = null
    private val monthMap: MutableMap<Int, String> = mutableMapOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setUpMonthMap()
        binding = DatePickerBinding.inflate(inflater, container, false)
        return binding?.root
    }

    private fun setUpMonthMap() {
        monthMap[1] = "January"
        monthMap[2] = "February"
        monthMap[3] = "March"
        monthMap[4] = "April"
        monthMap[5] = "May"
        monthMap[6] = "June"
        monthMap[7] = "July"
        monthMap[8] = "August"
        monthMap[9] = "September"
        monthMap[10] = "October"
        monthMap[11] = "November"
        monthMap[12] = "December"
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.datePickerCalendar?.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val pattern = "dd MMMM, yyyy"
            val simpleDateFormat = SimpleDateFormat(pattern)
            val formattedDate = simpleDateFormat.format(Date(binding?.datePickerCalendar?.date ?: 0))
            binding?.enteredDateLabel?.text = formattedDate
        }

        binding?.datePageGoBackButton?.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_FirstFragment_to_SwitchesPage)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

