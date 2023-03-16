package com.aop.interplay.ui.fragments.signup

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentPrivacyPolicyBinding

class PrivacyPolicyFragment : Fragment(R.layout.fragment_privacy_policy) {
    private lateinit var binding: FragmentPrivacyPolicyBinding
    private lateinit var btnNav: ImageButton
    private lateinit var privacyPolicyWebViewId: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentPrivacyPolicyBinding.bind(view)
        btnNav=binding.btnNav
        privacyPolicyWebViewId=binding.privacyPolicyWebViewId

//        Back stack navigation
        btnNav.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup)
        }

//        Web view
        privacyPolicyWebViewId.loadUrl("https://dev-aop.interplayapps.iterate.ai/privacy-policy")

        // Enable Javascript
        val webSettings: WebSettings = privacyPolicyWebViewId.settings
        webSettings.javaScriptEnabled = true

        // Force links and redirects to open in the WebView instead of in a browser
        privacyPolicyWebViewId.webViewClient = WebViewClient()

    }
}