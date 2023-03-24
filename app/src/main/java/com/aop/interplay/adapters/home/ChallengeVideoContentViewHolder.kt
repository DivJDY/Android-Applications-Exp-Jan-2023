package com.aop.interplay.adapters.home

import android.graphics.Color
import com.aop.interplay.R
import com.aop.interplay.adapters.BaseViewHolder
import com.aop.interplay.custom_views.truncatingtextview.OnTruncatingTextViewListener
import com.aop.interplay.data.network.HomePost
import com.aop.interplay.databinding.VideoViewChallengeItemBinding
import com.aop.interplay.extensions.loadCircularImage
import com.aop.interplay.listeners.VideoInteractionListener
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.ui.StyledPlayerView

class ChallengeVideoContentViewHolder(
    binding: VideoViewChallengeItemBinding,
    private val videoInteractionListener: VideoInteractionListener
) : BaseViewHolder<HomePost>(binding) {

    override fun bind(dataModel: HomePost) {
        super.bind(dataModel)
        with(binding as VideoViewChallengeItemBinding) {
            videoInfoLayout.tvUserName.text = dataModel.userInfo.name
            videoInfoLayout.tvVideoDescription.text = dataModel.getDescriptionWithTags()
            videoCtaLayout.ivProfile.loadCircularImage(
                R.drawable.profile_pic, 8f, Color.WHITE
            )
            dataModel.challengeType?.takeIf { it.isNotBlank() }?.let {
                if (it == "challenge") {
                    Glide.with(root.context).load(R.drawable.badge_challenge_default).into(videoInfoLayout.ivChallengeType)
                } else {
                    Glide.with(root.context).load(R.drawable.badge_assignment_default).into(videoInfoLayout.ivChallengeType)
                }
            }

            playerViewFrameLayout.setOnClickListener {
                videoInteractionListener.onVideoClicked()
            }

            videoCtaLayout.buttonStar.setOnCheckedChangeListener { _, isChecked ->
                videoInteractionListener.onStarClicked(isChecked)
            }

            videoCtaLayout.buttonBookmark.setOnCheckedChangeListener { _, isChecked ->
                videoInteractionListener.onBookmarkClicked(isChecked)
            }

            videoCtaLayout.buttonShare.setOnClickListener {
                videoInteractionListener.onShareClicked()
            }

            videoCtaLayout.ivProfile.setOnClickListener {
                videoInteractionListener.onProfileClicked()
            }

            buttonLearn.setOnClickListener {
                videoInteractionListener.onLearnClicked()
            }

            buttonTry.setOnClickListener {
                videoInteractionListener.onTryClicked()
            }

            videoInfoLayout.tvVideoDescription.setListener(object : OnTruncatingTextViewListener {
                override fun onExpandClicked() {
                    videoInteractionListener.onDescriptionExpanded()
                }

                override fun onCollapseClicked() {
                    videoInteractionListener.onDescriptionCollapsed()
                }
            })
        }
    }

    override var playerView: StyledPlayerView? = binding.playerView
}