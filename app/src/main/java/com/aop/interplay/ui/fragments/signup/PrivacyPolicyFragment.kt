package com.aop.interplay.ui.fragments.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentPrivacyPolicyBinding
import com.aop.interplay.ui.fragments.BaseFragment

class PrivacyPolicyFragment : BaseFragment() {
    private var _binding: FragmentPrivacyPolicyBinding? = null
    private val privacyPolicy = "https://dev-aop.interplayapps.iterate.ai/privacy-policy"
    private val webViewTitle = "Privacy Policy"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentPrivacyPolicyBinding.inflate(inflater, container, false)
        return _binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPrivacyPolicyBinding.bind(view)

        _binding?.privacyPolicyId?.topNavHandleId?.btnNav?.setOnClickListener {
            findNavController().navigate(R.id.navigation_signup)
        }
        webViewRunUrlAndTitle(privacyPolicy,webViewTitle)
    }

    private fun webViewRunUrlAndTitle(url:String, title:String){
        _binding?.privacyPolicyId?.webViewId?.webViewClient = MyWebViewClient()
        // Loading a URL
        _binding?.privacyPolicyId?.webViewId?.loadUrl(url)

        _binding?.privacyPolicyId?.topNavHandleId?.webViewTitleId?.text = title
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
            _binding?.privacyPolicyId?.webViewProgressBarId?.visibility = View.GONE
        }
    }
}