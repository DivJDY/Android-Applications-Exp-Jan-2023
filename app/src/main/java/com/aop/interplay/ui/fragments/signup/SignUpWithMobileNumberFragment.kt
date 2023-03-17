package com.aop.interplay.ui.fragments.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentSignUpWithMobileNumberBinding
import com.aop.interplay.ui.fragments.BaseFragment


class SignUpWithMobileNumberFragment : BaseFragment() {
    private lateinit var binding: FragmentSignUpWithMobileNumberBinding
    private var title = "Sign Up"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up_with_mobile_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpWithMobileNumberBinding.bind(view)
        binding.topNavHandleId.webViewTitleId.text = title
        binding.signUpMobileInputNumber.setOnClickListener {
            print("Message  == " + isValidateMobileNumber())
            if (isValidateMobileNumber()) {
                Toast.makeText(
                    activity,
                    "Valid phone number " + binding.signUpMobileInputNumber.length() + " digits",
                    Toast.LENGTH_SHORT
                ).show()
                binding.signUpNextMobileId.backgroundTintList =
                    resources.getColorStateList(R.color.signUpBtn)
                binding.signUpNextMobileId.setTextColor(resources.getColorStateList(R.color.black))
            }
        }

        binding.topNavHandleId.btnNav.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup)
        }
    }

    //   input Validation
    private fun isValidateMobileNumber() = binding.signUpMobileInputNumber.length() == 10
}
