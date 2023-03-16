package com.aop.interplay.ui.fragments.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentPrivacyPolicyBinding

class PrivacyPolicyFragment : Fragment(R.layout.fragment_privacy_policy) {
    private lateinit var binding: FragmentPrivacyPolicyBinding
    private lateinit var btnNav: ImageButton
    private lateinit var privacyPolicyWebViewId: WebView
    private lateinit var webViewProgressBar:ProgressBar


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentPrivacyPolicyBinding.bind(view)
        btnNav=binding.btnNav
        privacyPolicyWebViewId=binding.privacyPolicyWebViewId
        webViewProgressBar=binding.webViewProgressBar


//        Back stack navigation
        btnNav.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup)
        }

//        Back stack navigation
        btnNav.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup)
        }

        // Setting a webViewClient
        privacyPolicyWebViewId.webViewClient = WebViewClient()
        // Loading a URL
        privacyPolicyWebViewId.loadUrl("https://dev-aop.interplayapps.iterate.ai/privacy-policy")


    }

    inner class WebViewClient : android.webkit.WebViewClient() {
        // Load the URL
        @Deprecated("Deprecated in Java")
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        // ProgressBar will disappear once page is loaded
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            webViewProgressBar.visibility = View.GONE
        }
    }
}