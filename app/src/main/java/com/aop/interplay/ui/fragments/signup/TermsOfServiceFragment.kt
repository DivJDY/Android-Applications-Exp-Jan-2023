package com.aop.interplay.ui.fragments.signup


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebView
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentTermsOfServiceBinding


class TermsOfServiceFragment : Fragment(R.layout.fragment_terms_of_service) {
    private lateinit var binding: FragmentTermsOfServiceBinding
    private lateinit var btnNav:ImageButton
    private lateinit var termsOfServiceWebViewId:WebView
    private lateinit var webViewProgressBar:ProgressBar


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentTermsOfServiceBinding.bind(view)
        btnNav=binding.btnNav
        termsOfServiceWebViewId=binding.termsOfServiceWebViewId
        webViewProgressBar=binding.webViewProgressBar

//        Back stack navigation
        btnNav.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup)
        }

        // Setting a webViewClient
        termsOfServiceWebViewId.webViewClient = WebViewClient()
        // Loading a URL
        termsOfServiceWebViewId.loadUrl("https://dev-aop.interplayapps.iterate.ai/terms-of-use")

    }



    // Overriding WebViewClient functions
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