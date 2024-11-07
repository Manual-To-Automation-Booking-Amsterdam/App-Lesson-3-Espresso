package com.example.lesson2_basictest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson2_basictest.databinding.FragmentFirstBinding
import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.DatePicker
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment
import java.util.Calendar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var alertDialog: AlertDialog
    private lateinit var alertBuilder: AlertDialog.Builder
    private lateinit var datePicker: DatePicker
    private lateinit var calendar: Calendar
    private lateinit var dateView: TextView
    private var year = 0
    private var month = 0
    private var day = 0

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        buildAlertDialog()

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.alertButton.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }

        binding.alertButton.setOnClickListener {
            alertDialog.show();
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).contentDescription = "Yes";
            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).contentDescription = "No";
        }

//        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setContentDescription("Yes");
//        alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setContentDescription("No");

        binding.textFieldButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_TextFieldPage)
        }

        binding.formButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_FormPage)
        }

        binding.switchesButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SwitchesPage)
        }

        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_LoginPage)
        }

//        binding.dateButton.setOnClickListener(view1 -> NavHostFragment.findNavController(FirstFragment.this)
//        .navigate(R.id.action_FirstFragment_to_datePickerPage));
//
//        binding.switchButton.setOnClickListener(view1 -> NavHostFragment.findNavController(FirstFragment.this)
//        .navigate(R.id.action_FirstFragment_to_switchPage));
//
//        binding.listButton.setOnClickListener(view1 -> NavHostFragment.findNavController(FirstFragment.this)
//        .navigate(R.id.action_Go_To_List_Page));
    }

    private fun buildAlertDialog() {
        alertBuilder = AlertDialog.Builder(requireContext())
        alertBuilder.setMessage("Show Alert page")
        alertBuilder.setCancelable(true)

        alertBuilder.setPositiveButton("Yes") { dialog, id ->
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        alertBuilder.setNegativeButton("No") { dialog, id -> dialog.cancel() }

        alertDialog = alertBuilder.create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}