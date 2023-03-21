package com.aop.interplay.ui.fragments.signup

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentSignUpWithMobileNumberBinding
import com.aop.interplay.ui.fragments.BaseFragment

class SignUpWithMobileNumberFragment : BaseFragment() {
    private var binding: FragmentSignUpWithMobileNumberBinding? = null
    private var title = "Sign Up"

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSignUpWithMobileNumberBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpWithMobileNumberBinding.bind(view)
        binding?.topNavHandleId?.webViewTitleId?.text = title
        binding?.topNavHandleId?.btnNav?.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup)
        }

        binding?.mobileTxtInputLayout?.requestFocus()
        binding?.mobileTxtInputLayout?.boxStrokeColor= context?.getColor(R.color.white)!!

        binding?.signUpNextMobileId?.setOnClickListener {
            Log.d("Proceed to ", "Verify Mobile Screen")
        }

        binding?.mobileNumberId?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val mobileNumber: String =
                    binding?.mobileTxtInputLayout?.editText?.text.toString().trim()
                if (mobileNumber.length != 10) {
                    binding?.mobileTxtInputLayout?.error = "Invalid mobile number"
                    false
                } else {
                    binding?.mobileTxtInputLayout?.error = null
                    true
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val isValid = validateMobileNumber(s.toString())
                if (isValid) {
                    val btnBg = context?.getColor(R.color.btnSuccess)
                    val color = context?.getColor(R.color.black)
                    if (btnBg != null && color != null) {
                        binding?.signUpNextMobileId?.setBackgroundColor(btnBg)
                        binding?.signUpNextMobileId?.setTextColor(color)
                    }
                }
            }
        })
    }

    fun validateMobileNumber(input: String): Boolean {
        val regex = Regex("^\\d{10}$")
        return regex.matches(input)
    }

}
