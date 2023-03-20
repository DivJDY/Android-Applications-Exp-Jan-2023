package com.aop.interplay.ui.fragments.signup


import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentPrivacyPolicyBinding
import com.aop.interplay.databinding.FragmentTermsOfServiceBinding


class TermsOfServiceFragment : Fragment(R.layout.fragment_terms_of_service) {
    private var _binding: FragmentTermsOfServiceBinding? = null
    private val termsOfUse = "https://dev-aop.interplayapps.iterate.ai/terms-of-use"
    private val webViewTitle = "Terms Of Use"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTermsOfServiceBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTermsOfServiceBinding.bind(view)

        _binding!!.termsOfUseId.topNavHandleId.btnNav.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup)
        }
        webViewRunUrlAndTitle(termsOfUse,webViewTitle)
    }

    private fun webViewRunUrlAndTitle(url:String, title:String){
        _binding?.termsOfUseId?.webViewId?.webViewClient = MyWebViewClient()
        // Loading a URL
        _binding?.termsOfUseId?.webViewId?.loadUrl(url)

        _binding?.termsOfUseId?.topNavHandleId?.webViewTitleId?.text = title
    }

    inner class MyWebViewClient : WebViewClient() {
        // Load the URL
        @Deprecated("Deprecated in Java")
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        // ProgressBar will disappear once page is loaded
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            _binding?.termsOfUseId?.webViewProgressBarId?.visibility = View.GONE
        }
    }
}