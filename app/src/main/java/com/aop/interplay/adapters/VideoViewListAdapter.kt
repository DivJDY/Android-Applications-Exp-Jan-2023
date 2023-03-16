package com.aop.interplay.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aop.interplay.R
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.aop.interplay.custom_views.listeners.OnTruncatingTextViewListener
import com.aop.interplay.data.network.HomePost
import com.aop.interplay.databinding.AdapterVideoViewItemBinding
import com.aop.interplay.extensions.loadCircularImage
import com.aop.interplay.listeners.VideoInteractionListener
import com.bumptech.glide.Glide

class VideoViewListAdapter(
    private val videosList: List<HomePost>,
    private val exoPlayer: ExoPlayer,
    private val videoInteractionListener: VideoInteractionListener
) : RecyclerView.Adapter<VideoViewListAdapter.VideoViewViewHolder>() {

    inner class VideoViewViewHolder(val viewBinding: AdapterVideoViewItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterVideoViewItemBinding.inflate(
            inflater, parent, false
        )

        return VideoViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewViewHolder, position: Int) {
        val item = videosList[position]
        with(holder.viewBinding) {

            tvUserName.text = item.userName
            tvVideoDescription.text = item.description
            ivProfile.loadCircularImage(
                R.drawable.profile_pic,
                8f,
                Color.WHITE
            )

            playerViewFrameLayout.setOnClickListener {
                videoInteractionListener.onVideoClicked()
            }

            buttonStar.setOnCheckedChangeListener { _, isChecked ->
                videoInteractionListener.onStarClicked(isChecked)
            }

            buttonBookmark.setOnCheckedChangeListener { _, isChecked ->
                videoInteractionListener.onBookmarkClicked(isChecked)
            }

            buttonShare.setOnClickListener {
                videoInteractionListener.onShareClicked()
            }

            ivProfile.setOnClickListener {
                videoInteractionListener.onProfileClicked()
            }

            buttonLearn.setOnClickListener {
                videoInteractionListener.onLearnClicked()
            }

            buttonTry.setOnClickListener {
                videoInteractionListener.onTryClicked()
            }

            tvVideoDescription.setListener(object: OnTruncatingTextViewListener {
                override fun onExpandClicked() {
                    videoInteractionListener.onDescriptionExpanded()
                }

                override fun onCollapseClicked() {
                    videoInteractionListener.onDescriptionCollapsed()
                }
            })
        }
    }

    override fun onViewAttachedToWindow(holder: VideoViewViewHolder) {
        super.onViewAttachedToWindow(holder)
        with(holder) {
            val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
            val hlsMediaSource = HlsMediaSource.Factory(dataSourceFactory)
                .createMediaSource(MediaItem.fromUri(videosList[holder.adapterPosition].url))

            exoPlayer.setMediaSource(hlsMediaSource)
            exoPlayer.prepare()

            viewBinding.playerView.player = exoPlayer
        }
    }

    override fun getItemCount() = videosList.size
}