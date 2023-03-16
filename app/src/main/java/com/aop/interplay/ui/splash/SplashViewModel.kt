package com.aop.interplay.ui.splash

import com.aop.interplay.network.remote.NetworkRepository
import com.aop.interplay.ui.fragments.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    networkRepository: NetworkRepository
) : BaseViewModel(networkRepository)