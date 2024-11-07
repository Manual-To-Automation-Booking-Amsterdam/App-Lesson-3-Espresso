package com.example.lesson2_basictest

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.example.lesson2_basictest.databinding.LoginPageBinding

class LoginPage : Fragment() {
    private var binding: LoginPageBinding? = null
    private val errorMessage = "No text was entered!"
    private var loginSuccess = false
    private lateinit var alertDialog: AlertDialog
    private lateinit var alertBuilder: AlertDialog.Builder

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginPageBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        // Bind views
        val usernameEditText: EditText = view.findViewById(R.id.loginUsername)
        val passwordEditText: EditText = view.findViewById(R.id.loginPassword)
        val submitButton: Button = view.findViewById(R.id.loginSubmitButton)

        // Observe ViewModel login state
        loginViewModel.loginResult.observe(viewLifecycleOwner, Observer { result ->
            if (result) {
                Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        })

        // TextChange listeners to update ViewModel
        usernameEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                loginViewModel.setUsername(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                loginViewModel.setPassword(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Button click listener
        submitButton.setOnClickListener {
            loginSuccess = loginViewModel.login()

            buildAlertDialog(loginSuccess)
            alertDialog.show();
        }

        binding?.loginPageGoBackButton?.setOnClickListener {
            NavHostFragment.findNavController(this
            )
                .navigate(R.id.action_LoginPage_to_FirstFragment)
        }
    }

    private fun buildAlertDialog(loginSuccess: Boolean) {
        alertBuilder = AlertDialog.Builder(requireContext())
        if (loginSuccess) {
            alertBuilder.setMessage("Login Successful")
        } else {
            alertBuilder.setMessage("Login Failed")
        }

        alertBuilder.setCancelable(true)
        alertBuilder.setPositiveButton("Ok") { dialog, id -> dialog.cancel() }

        alertDialog = alertBuilder.create()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}