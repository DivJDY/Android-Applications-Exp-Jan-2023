package com.aop.interplay.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aop.interplay.adapters.BaseViewHolder
import com.aop.interplay.data.network.HomePost
import com.aop.interplay.databinding.VideoViewChallengeItemBinding
import com.aop.interplay.databinding.VideoViewSimpleItemBinding
import com.aop.interplay.listeners.VideoInteractionListener
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource

class VideoViewListAdapter(
    private val videosList: List<HomePost>,
    private val videoInteractionListener: VideoInteractionListener
) : RecyclerView.Adapter<BaseViewHolder<Any>>() {

    override fun getItemViewType(position: Int): Int {
        // TODO: testing logic. refine conditions once all the layouts are ready
        return if (videosList[position].challengeType == "classPreview") {
            2
        } else {
            1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        val inflater = LayoutInflater.from(parent.context)
        return (when (viewType) {
            1 -> SimpleVideoContentViewHolder(
                VideoViewSimpleItemBinding.inflate(
                    inflater, parent, false
                ), videoInteractionListener
            )
            2 -> ChallengeVideoContentViewHolder(
                VideoViewChallengeItemBinding.inflate(
                    inflater, parent, false
                ), videoInteractionListener
            )
            else -> throw IllegalAccessException("Unknown layout type")
        }) as BaseViewHolder<Any>
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Any>, position: Int) {
        holder.bind(videosList[position])
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder<Any>) {
        super.onViewAttachedToWindow(holder)
        with(holder) {
            val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
            val hlsMediaSource = HlsMediaSource.Factory(dataSourceFactory)
                .createMediaSource(MediaItem.fromUri(videosList[adapterPosition].videoInfo.url))

            getNewPlayerInstance().apply {
                setMediaSource(hlsMediaSource)
                prepare()
                playerView?.player = this
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<Any>) {
        super.onViewDetachedFromWindow(holder)
        holder.playerView?.player?.pause()
        holder.playerView?.player?.release()
    }

    override fun getItemCount() = videosList.size
}