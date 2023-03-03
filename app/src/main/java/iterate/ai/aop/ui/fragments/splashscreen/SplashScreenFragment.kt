package iterate.ai.aop.ui.fragments.splashscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import iterate.ai.aop.R
import iterate.ai.aop.databinding.FragmentSplashScreenBinding
import iterate.ai.aop.ui.fragments.BaseFragment

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreenFragment : BaseFragment() {

    private var _binding: FragmentSplashScreenBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.videoViewId) {
            setVideoURI(viewModel.getPathUri())
            start()
            setOnCompletionListener {
                Navigation.findNavController(view).navigate(R.id.move_to_home_fragment)
            }
        }
    }
}