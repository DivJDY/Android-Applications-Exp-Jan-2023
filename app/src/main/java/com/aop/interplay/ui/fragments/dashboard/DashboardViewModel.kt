package com.aop.interplay.ui.fragments.dashboard

import com.aop.interplay.network.remote.NetworkRepository
import com.aop.interplay.ui.fragments.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private var networkRepository: NetworkRepository
) : BaseViewModel(networkRepository)