package com.aop.interplay

import android.app.Activity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import javax.inject.Inject

class NavigationManager @Inject constructor(
    private val activity: Activity
) {
    fun navigateToWebFragment(title: String, url: String) {
        activity.findNavController(R.id.nav_host_fragment_activity_main).navigate(
            R.id.toWebFragment, bundleOf(
                "title" to title, "url" to url
            )
        )
    }
}