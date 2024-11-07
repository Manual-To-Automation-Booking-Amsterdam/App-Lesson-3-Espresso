package com.example.lesson2_basictest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.lesson2_basictest.databinding.FormPageBinding

class FormPage : Fragment() {
    private var binding: FormPageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FormPageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(@NonNull view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.formSubmitButton?.setOnClickListener {
            binding?.formNameLabel?.text = StringBuilder().append(binding?.formNameLabel?.text.toString())
                .append(" ").append(binding?.firstNameFormField?.text.toString())
                .append(" ").append(binding?.lastNameFormField?.text.toString()).toString()

            binding?.formEmailLabel?.text = StringBuilder().append(binding?.formEmailLabel?.text.toString())
                .append(" ").append(binding?.emailAddressFormField?.text.toString()).toString()
        }

        binding?.formGoBackButton?.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_formPage_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

