package com.aop.interplay.ui.fragments.signup

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentSignUpBinding

//SignUp
class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var textView3:TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSignUpBinding.bind(view)
        binding.signUpMobileId.setOnClickListener { findNavController().navigate(R.id.navigation_signupMobile) }
        textView3=binding.textView3

        val text = "By continuing, you agree to our Terms of Service and acknowledge that you have read our Privacy Policy"
        val spannableString = SpannableString(text)
        val clickableSpan1: ClickableSpan = object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.WHITE
            }

            override fun onClick(widget: View) {
                findNavController().navigate(R.id.navigation_termsCondition)
            }
        }
        spannableString.setSpan(clickableSpan1, 32, 48, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)


        textView3.setText(spannableString, TextView.BufferType.SPANNABLE)
        textView3.movementMethod = LinkMovementMethod.getInstance()
        val clickableSpan2: ClickableSpan = object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.WHITE
            }

            override fun onClick(widget: View) {
                findNavController().navigate(R.id.navigation_privacyPolicy)
            }
        }
        spannableString.setSpan(clickableSpan2, 88, 102, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView3.setText(spannableString, TextView.BufferType.SPANNABLE)
        textView3.movementMethod = LinkMovementMethod.getInstance()
    }

}