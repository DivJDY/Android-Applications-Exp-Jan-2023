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
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentSignUpBinding
import com.aop.interplay.ui.fragments.BaseFragment

//SignUp
class SignUpFragment : BaseFragment() {
    private var binding: FragmentSignUpBinding? = null
    private lateinit var text: String
    private lateinit var spannableString: SpannableString

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentSignUpBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text = context?.getString(R.string.disclaimerTxt).toString()

        spannableString = SpannableString(text)
        binding = FragmentSignUpBinding.bind(view)
        binding?.signUpMobileId?.setOnClickListener { findNavController().navigate(R.id.navigation_signupMobile) }

        makeTextSpanMove(R.id.navigation_termsCondition, 32, 48)
        makeTextSpanMove(R.id.navigation_privacyPolicy, 88, 102)
    }

    private fun makeTextSpanMove(navigation: Int, startInd: Int, endInd: Int) {
        spannableString.setSpan(clickableSpanLink(navigation), startInd, endInd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding?.textView3?.setText(spannableString, TextView.BufferType.SPANNABLE)
        binding?.textView3?.movementMethod = LinkMovementMethod.getInstance()
    }
}

//ClickableSpanLink function
fun Fragment.clickableSpanLink(nav: Int): ClickableSpan {
    return object : ClickableSpan() {
        override fun updateDrawState(ds: TextPaint) {
            super.updateDrawState(ds)
            ds.color = Color.WHITE
        }
        override fun onClick(widget: View) {
            findNavController().navigate(nav)
        }
    }
}


