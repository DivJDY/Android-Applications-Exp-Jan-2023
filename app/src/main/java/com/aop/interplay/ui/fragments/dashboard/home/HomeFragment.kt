package com.aop.interplay.ui.fragments.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.exoplayer2.ExoPlayer
import dagger.hilt.android.AndroidEntryPoint
import com.aop.interplay.adapters.VideoViewListAdapter
import com.aop.interplay.data.network.HomePost
import com.aop.interplay.databinding.FragmentHomeBinding
import com.aop.interplay.listeners.VideoInteractionListener
import com.aop.interplay.ui.fragments.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment(), VideoInteractionListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private var exoPlayer: ExoPlayer? = null

    private var adapter: VideoViewListAdapter? = null
    private var listData: MutableList<HomePost> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    override fun onDestroyView() {
        exoPlayer?.release()
        exoPlayer = null
        _binding = null
        super.onDestroyView()
    }

    override fun onStarClicked(isEnabled: Boolean) {
        // TODO: call API call
    }

    override fun onBookmarkClicked(isEnabled: Boolean) {
        // TODO: call API call
    }

    override fun onShareClicked() {
        // TODO: call API call
    }

    override fun onProfileClicked() {
        // TODO: open user profile
    }

    override fun onVideoClicked() {
        exoPlayer?.let {
            if (it.isPlaying) {
                it.pause()
            } else {
                it.play()
            }
        }
    }

    override fun onLearnClicked() {
        // TODO: open screen
    }

    override fun onTryClicked() {
        // TODO: open screen
    }

    override fun onDescriptionExpanded() {
        // TODO: add analytics
    }

    override fun onDescriptionCollapsed() {
        // TODO: add analytics
    }

    private fun initViews() {
        exoPlayer = ExoPlayer.Builder(requireContext()).build().apply {
            playWhenReady = true
        }
        exoPlayer?.let {
            adapter = VideoViewListAdapter(listData, it, this)
            binding.viewPager.adapter = adapter
            viewModel.getHomeVideos()
        }
    }

    private fun initObservers() {
        viewModel.content.observe(viewLifecycleOwner) {
            it?.let {
                listData.clear()
                listData.addAll(it)
                adapter?.notifyDataSetChanged()
            }
        }
    }
}