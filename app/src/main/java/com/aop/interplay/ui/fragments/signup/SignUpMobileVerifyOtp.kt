package com.aop.interplay.ui.fragments.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentSignUpMobileVerifyOtpBinding
import com.aop.interplay.ui.fragments.BaseFragment

class SignUpMobileVerifyOtp : BaseFragment() {
    private var binding: FragmentSignUpMobileVerifyOtpBinding? = null
    private val title = "Sign Up"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSignUpMobileVerifyOtpBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpMobileVerifyOtpBinding.bind(view)
        binding?.topNavHandleId?.webViewTitleId?.text = title
        binding?.topNavHandleId?.btnNav?.setOnClickListener {
            findNavController().navigate(R.id.navigation_signupMobile)
        }

        binding?.txt?.text = arguments?.getString("OTP")
    }

}