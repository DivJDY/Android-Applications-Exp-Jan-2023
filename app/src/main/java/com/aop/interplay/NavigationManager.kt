package com.aop.interplay

import android.app.Activity
import javax.inject.Inject

class NavigationManager @Inject constructor(
    private val activity: Activity
)