package com.example.lesson2_basictest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.lesson2_basictest.databinding.TextFieldPageBinding

class TextFieldPage : Fragment() {
    private var binding: TextFieldPageBinding? = null
    private val errorMessage = "No text was entered!"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TextFieldPageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.textFieldSubmitButton?.setOnClickListener {
            if (binding?.textField?.text.toString().isEmpty()) {
                binding?.textFieldErrorLabel?.text = errorMessage
            } else {
                binding?.enteredTextLabel?.text = buildString {
                    append(binding?.enteredTextLabel?.text)
                        append(" ")
                            append(binding?.textField?.text)
    }
                binding?.textFieldErrorLabel?.text = ""
            }
        }

        binding?.textFieldPageGoBackButton?.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_textFieldPage_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

