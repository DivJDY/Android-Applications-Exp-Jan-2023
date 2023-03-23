package com.aop.interplay.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aop.interplay.R
import com.aop.interplay.custom_views.truncatingtextview.OnTruncatingTextViewListener
import com.aop.interplay.data.network.HomePost
import com.aop.interplay.databinding.AdapterVideoViewItemBinding
import com.aop.interplay.extensions.loadCircularImage
import com.aop.interplay.listeners.VideoInteractionListener
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class VideoViewListAdapter(
    private val videosList: List<HomePost>,
    private val videoInteractionListener: VideoInteractionListener
) : RecyclerView.Adapter<VideoViewListAdapter.VideoViewViewHolder>() {

    inner class VideoViewViewHolder(val viewBinding: AdapterVideoViewItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return VideoViewViewHolder(
            AdapterVideoViewItemBinding.inflate(
                inflater, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoViewViewHolder, position: Int) {
        val item = videosList[position]
        with(holder.viewBinding) {
            tvUserName.text = item.userName
            tvVideoDescription.text = item.description
            ivProfile.loadCircularImage(
                R.drawable.profile_pic, 8f, Color.WHITE
            )
            item.type?.badge?.takeIf { it.isNotBlank() }?.let {
                Glide.with(root.context).load(it).into(ivChallengeType)
            }

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

            tvVideoDescription.setListener(object : OnTruncatingTextViewListener {
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
                .createMediaSource(MediaItem.fromUri(videosList[adapterPosition].videoInfo.url))

            val exoPlayer =
                ExoPlayer.Builder(holder.viewBinding.root.context).setUseLazyPreparation(true)
                    .build().apply {
                    playWhenReady = true
                    repeatMode = Player.REPEAT_MODE_ALL
                }
            exoPlayer.setMediaSource(hlsMediaSource)
            exoPlayer.prepare()

            viewBinding.playerView.player = exoPlayer
        }
    }

    override fun onViewDetachedFromWindow(holder: VideoViewViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.viewBinding.playerView.player?.pause()
        holder.viewBinding.playerView.player?.release()
    }

    override fun getItemCount() = videosList.size
}