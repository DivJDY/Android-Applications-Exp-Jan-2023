package com.aop.interplay.ui.fragments.signup

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentSignUpBinding
import com.aop.interplay.ui.fragments.BaseFragment

//SignUp
class SignUpFragment : BaseFragment() {
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var clickableSpanTerms: ClickableSpan
    private lateinit var clickableSpanPrivacy: ClickableSpan

    // private var text = context?.getText(R.string.disclaimerTxt)
    // private val spannableString = SpannableString(text.toString())
    private var text =
        "By continuing, you agree to our Terms of Service and acknowledge that you have read our Privacy Policy."
    private val spannableString = SpannableString(text)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)
        binding.signUpMobileId.setOnClickListener { findNavController().navigate(R.id.navigation_signupMobile) }

        clickableSpanTerms = clickableSpanLink(R.id.navigation_termsCondition)
        makeTextSpanMove(clickableSpanTerms, 32, 48)

        clickableSpanPrivacy = clickableSpanLink(R.id.navigation_privacyPolicy)
        makeTextSpanMove(clickableSpanPrivacy, 88, 102)

    }

    private fun clickableSpanLink(nav: Int): ClickableSpan {
        var clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.WHITE
            }
            override fun onClick(widget: View) {
                findNavController().navigate(nav)
            }
        }
        return clickableSpan
    }

    private fun makeTextSpanMove(clickableSpan: ClickableSpan, startInd: Int, endInd: Int) {
        spannableString.setSpan(clickableSpan, startInd, endInd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.textView3.setText(spannableString, TextView.BufferType.SPANNABLE)
        binding.textView3.movementMethod = LinkMovementMethod.getInstance()
    }

}