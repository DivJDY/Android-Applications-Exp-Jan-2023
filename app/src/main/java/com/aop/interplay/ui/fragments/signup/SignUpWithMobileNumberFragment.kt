package com.aop.interplay.ui.fragments.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentSignUpWithMobileNumberBinding
import com.aop.interplay.ui.fragments.BaseFragment


class SignUpWithMobileNumberFragment : BaseFragment() {
    private var binding: FragmentSignUpWithMobileNumberBinding? =null
    private var title = "Sign Up"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentSignUpWithMobileNumberBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpWithMobileNumberBinding.bind(view)
        binding?.topNavHandleId?.webViewTitleId?.text = title
        binding?.topNavHandleId?.btnNav?.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup)
        }
    }
}
