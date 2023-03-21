package com.aop.interplay.ui.fragments.dashboard

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.aop.interplay.R
import com.aop.interplay.databinding.FragmentDashboardBinding
import com.aop.interplay.ui.fragments.BaseFragment
import com.aop.interplay.ui.fragments.dashboard.discover.DiscoverFragment
import com.aop.interplay.ui.fragments.dashboard.home.HomeFragment
import com.aop.interplay.ui.fragments.dashboard.learn.LearnFragment
import com.aop.interplay.ui.fragments.dashboard.newpost.NewPostFragment
import com.aop.interplay.ui.fragments.dashboard.profile.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DashboardViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()

        binding.navView.setupFragments(
            childFragmentManager, R.id.nav_host_fragment, listOf(
                HomeFragment(),
                DiscoverFragment(),
                NewPostFragment(),
                LearnFragment(),
                ProfileFragment()
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun setupToolbar() {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.mainToolbar.toolbar)
        setHasOptionsMenu(true)
    }
}