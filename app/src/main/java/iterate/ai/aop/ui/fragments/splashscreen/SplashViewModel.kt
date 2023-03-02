package iterate.ai.aop.ui.fragments.splashscreen

import android.net.Uri
import dagger.hilt.android.lifecycle.HiltViewModel
import iterate.ai.aop.BuildConfig
import iterate.ai.aop.R
import iterate.ai.aop.ui.fragments.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {

    fun getPathUri(): Uri =
        Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/" + R.raw.splash_screen)
}