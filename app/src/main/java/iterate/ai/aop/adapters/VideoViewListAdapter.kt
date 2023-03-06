package iterate.ai.aop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import iterate.ai.aop.custom_views.listeners.OnTruncatingTextViewListener
import iterate.ai.aop.databinding.AdapterVideoViewItemBinding
import iterate.ai.aop.listeners.VideoInteractionListener

class VideoViewListAdapter(
    private val videosList: List<String>,
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
        with(holder.viewBinding) {
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
                .createMediaSource(MediaItem.fromUri(videosList[holder.adapterPosition]))

            exoPlayer.setMediaSource(hlsMediaSource)
            exoPlayer.prepare()

            viewBinding.playerView.player = exoPlayer
        }
    }

    override fun getItemCount() = videosList.size
}