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
import com.aop.interplay.databinding.FragmentTermsOfServiceBinding


class TermsOfServiceFragment : Fragment(R.layout.fragment_terms_of_service) {
    private lateinit var binding: FragmentTermsOfServiceBinding
    private lateinit var btnNav:ImageButton
    private lateinit var termsOfServiceWebViewId:WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentTermsOfServiceBinding.bind(view)
        btnNav=binding.btnNav
        termsOfServiceWebViewId=binding.termsOfServiceWebViewId

//        Back stack navigation
        btnNav.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup)
        }

//        Web view
        termsOfServiceWebViewId.loadUrl("https://dev-aop.interplayapps.iterate.ai/terms-of-use")

        // Enable Javascript
        val webSettings: WebSettings = termsOfServiceWebViewId.settings
        webSettings.javaScriptEnabled = true

        // Force links and redirects to open in the WebView instead of in a browser
        termsOfServiceWebViewId.webViewClient = WebViewClient()

    }


}