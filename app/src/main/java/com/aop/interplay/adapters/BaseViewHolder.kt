package com.aop.interplay.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.StyledPlayerView

open class BaseViewHolder<T>(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    open fun bind(dataModel: T) {

    }

    open var playerView: StyledPlayerView? = null

    val context: Context
        get() = binding.root.context

    fun getNewPlayerInstance() =
        ExoPlayer.Builder(context).setUseLazyPreparation(true).build().apply {
            playWhenReady = true
            repeatMode = Player.REPEAT_MODE_ALL
        }

}