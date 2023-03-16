package com.aop.interplay.ui.fragments.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aop.interplay.R
import dagger.hilt.android.AndroidEntryPoint
import com.aop.interplay.ui.fragments.BaseFragment

@AndroidEntryPoint
class DiscoverFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }
}