package com.example.lesson2_basictest

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.lesson2_basictest.databinding.SwitchPageBinding;
;
class SwitchesPage : Fragment() {
    private var binding: SwitchPageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SwitchPageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.switchOne?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding?.switchOneLabel?.text = "On"
                binding?.switchOneLabel?.setTextColor(Color.rgb(0, 255, 0))
            } else {
                binding?.switchOneLabel?.text = "Off"
                binding?.switchOneLabel?.setTextColor(Color.rgb(255, 0, 0))
            }
        }

        binding?.switchTwo?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding?.switchTwoLabel?.text = "On"
                binding?.switchTwoLabel?.setTextColor(Color.rgb(0, 255, 0))
            } else {
                binding?.switchTwoLabel?.text = "Off"
                binding?.switchTwoLabel?.setTextColor(Color.rgb(255, 0, 0))
            }
        }

        binding?.switchThree?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding?.switchThreeLabel?.text = "On"
                binding?.switchThreeLabel?.setTextColor(Color.rgb(0, 255, 0))
            } else {
                binding?.switchThreeLabel?.text = "Off"
                binding?.switchThreeLabel?.setTextColor(Color.rgb(255, 0, 0))
            }
        }

        binding?.switchFour?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding?.switchFourLabel?.text = "On"
                binding?.switchFourLabel?.setTextColor(Color.rgb(0, 255, 0))
            } else {
                binding?.switchFourLabel?.text = "Off"
                binding?.switchFourLabel?.setTextColor(Color.rgb(255, 0, 0))
            }
        }

        binding?.switchFive?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding?.switchFiveLabel?.text = "On"
                binding?.switchFiveLabel?.setTextColor(Color.rgb(0, 255, 0))
            } else {
                binding?.switchFiveLabel?.text = "Off"
                binding?.switchFiveLabel?.setTextColor(Color.rgb(255, 0, 0))
            }
        }

        binding?.switchPageGoBackButton?.setOnClickListener {
            NavHostFragment.findNavController(this
            )
                .navigate(R.id.action_switchPage_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}