package com.aop.interplay.ui.fragments.splashscreen

import android.net.Uri
import dagger.hilt.android.lifecycle.HiltViewModel
import com.aop.interplay.BuildConfig
import com.aop.interplay.R
import com.aop.interplay.ui.fragments.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {

    fun getPathUri(): Uri =
        Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/" + R.raw.splash_screen)
}