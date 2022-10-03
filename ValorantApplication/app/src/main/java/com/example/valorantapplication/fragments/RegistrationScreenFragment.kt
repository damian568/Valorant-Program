package com.example.valorantapplication.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.Constants
import com.example.valorantapplication.R
import com.example.valorantapplication.data.PreferenceUntil
import com.example.valorantapplication.data.User
import com.example.valorantapplication.databinding.FragmentRegistrationScreenBinding
import com.example.valorantapplication.enums.Gender

class RegistrationScreenFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationScreenBinding
    private lateinit var preferencesUntil: PreferenceUntil

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRegistrationScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferencesUntil = PreferenceUntil.getInstance(view.context)
        binding.progressBar.visibility = View.INVISIBLE
        onUsernameTextChangeListener()
        onEmailTextChangeListener()
        onPasswordTextChangeListener()
        onConfirmPasswordTextChangeListener()
        registerUser()
    }

    private fun onUsernameTextChangeListener() {
        binding.username.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.txtUsernameReg.error = checkIsItEmptyUsername()
                binding.btnReg.isEnabled = true
            }
        })
    }

    private fun onPasswordTextChangeListener() {
        binding.password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.txtPasswordReg.error = checkIsItEmptyPassword()
                binding.btnReg.isEnabled = true
            }
        })
    }

    private fun onConfirmPasswordTextChangeListener() {
        binding.confirmPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.txtConfirmPasswordReg.error = checkConfirmPassword()
                binding.btnReg.isEnabled = true
            }
        }
        )
    }

    private fun onEmailTextChangeListener() {
        binding.email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.txtEmailReg.error = checkIsItValidEmail()
                binding.btnReg.isEnabled = true
            }
        })
    }

    private fun checkIsItEmptyUsername(): String? {
        val username = binding.username.text.toString()
        if (TextUtils.isEmpty(username)) {
            return getString(R.string.return_text)
        }
        return null
    }

    private fun checkIsItEmptyPassword(): String? {
        val password = binding.password.text.toString()
        if (TextUtils.isEmpty(password)) {
            return getString(R.string.return_text)
        }
        return null
    }

    private fun checkConfirmPassword(): String? {
        val confirmPassword = binding.confirmPassword.text.toString()
        val password = binding.password.text.toString()
        if (TextUtils.isEmpty(confirmPassword)) {
            return getString(R.string.return_text)
        } else if (confirmPassword != password) {
            return getString(R.string.return_conpass_text)
        }
        return null
    }

    private fun checkIsItValidEmail(): String? {
        val emailText = binding.email.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return getString(R.string.return_email_text)
        }
        return null
    }

    private fun getSelectRadioBtnValue() =
        when (binding.radioGroupGender.checkedRadioButtonId) {
            R.id.btnRadioMan -> Gender.Male
            R.id.btnRadioWoman -> Gender.Female
            R.id.btnRadioOther -> Gender.Other
            else -> Gender.Other
        }

    private fun createUser() {
        val username = binding.username.text.toString()
        val password = binding.password.text.toString()
        val email = binding.email.text.toString()

        val user = User(
            username,
            password,
            email,
            getSelectRadioBtnValue()
        )
        preferencesUntil.saveUserData(user)
    }

    private fun registerUser() {
        binding.btnReg.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                checkIsItEmpty()
            }, Constants.DELAY_MILLS.toLong())
        }
    }

    private fun checkIsItEmpty() {
        val username = binding.txtUsernameReg.editText?.text.toString()
        val password = binding.txtPasswordReg.editText?.text.toString()
        val confirmPass = binding.txtConfirmPasswordReg.editText?.text.toString()
        val email = binding.txtEmailReg.editText?.text.toString()

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(email) || TextUtils.isEmpty(
                confirmPass)
        ) {
            showErrorToastVerification()
        } else {
            createUser()
            goToMainScreen()
        }
    }

    private fun showErrorToastVerification() {
        Toast.makeText(this.context, getString(R.string.field_toast), Toast.LENGTH_SHORT).show()
    }

    private fun goToMainScreen() {
        val action =
            RegistrationScreenFragmentDirections.actionRegistrationScreenFragmentToMainScreenFragment()
        findNavController().navigate(action)
    }
}