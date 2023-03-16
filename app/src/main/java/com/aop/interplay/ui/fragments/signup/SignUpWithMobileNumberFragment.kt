@file:Suppress("DEPRECATION")

package com.aop.interplay.ui.fragments.signup


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentSignUpWithMobileNumberBinding
import com.google.android.material.textfield.TextInputEditText


class SignUpWithMobileNumberFragment : Fragment(R.layout.fragment_sign_up_with_mobile_number) {

    private lateinit var binding: FragmentSignUpWithMobileNumberBinding
    private lateinit var signUpMobileInputNumber: TextInputEditText
    private lateinit var signUpNextMobileId: Button
    private lateinit var btnNav: ImageButton

    @SuppressLint("UseCompatLoadingForColorStateLists")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpWithMobileNumberBinding.bind(view)
        signUpMobileInputNumber = binding.signUpMobileInputNumber
        binding.signUpMobileInputLayout
        signUpNextMobileId = binding.signUpNextMobileId
        btnNav = binding.btnNav

        signUpMobileInputNumber.setOnClickListener {
            print("Message  == "+ isValidateMobileNumber())
            if (isValidateMobileNumber()) {
                Toast.makeText(
                    activity,
                    "Valid phone number " + signUpMobileInputNumber.length() + " digits",
                    Toast.LENGTH_SHORT
                ).show()
                signUpNextMobileId.backgroundTintList =
                    resources.getColorStateList(R.color.signUpBtn)
                signUpNextMobileId.setTextColor(resources.getColorStateList(R.color.black))
            }
        }


        btnNav.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup)
        }

    }

    private fun isValidateMobileNumber(): Boolean {
        if (signUpMobileInputNumber.length() == 10) {
            return true
        }
        return false
    }

}
