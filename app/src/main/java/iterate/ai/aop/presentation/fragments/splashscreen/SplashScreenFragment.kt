package iterate.ai.aop.presentation.fragments.splashscreen

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.navigation.Navigation
import iterate.ai.aop.BaseFragment
import iterate.ai.aop.BuildConfig
import iterate.ai.aop.R

class SplashScreenFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_screen,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val videoView = view.findViewById(R.id.videoViewId) as VideoView
        val path = "android.resource://" + BuildConfig.APPLICATION_ID + "/" + R.raw.splash_screen
        val uri = Uri.parse(path)
        videoView.setVideoURI(uri)
        videoView.start()
        videoView.setOnCompletionListener {

            Navigation.findNavController(view).navigate(R.id.move_to_home_fragment)
        }
        videoView.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.move_to_home_fragment)
        }
    }
}