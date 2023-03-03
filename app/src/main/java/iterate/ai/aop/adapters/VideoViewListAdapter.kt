package iterate.ai.aop.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import iterate.ai.aop.R
import kotlinx.android.synthetic.main.adapter_video_view_item.view.*

class VideoViewListAdapter(private val videosList: List<String>) :
    RecyclerView.Adapter<VideoViewListAdapter.ViewHolder>() {

    private lateinit var exoPlayer: ExoPlayer

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        exoPlayer = ExoPlayer.Builder(parent.context).build()
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_video_view_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)

        val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
        val hlsMediaSource = HlsMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(videosList[holder.adapterPosition]))

        exoPlayer.setMediaSource(hlsMediaSource)

        exoPlayer.playWhenReady = true
        exoPlayer.prepare()

        holder.itemView.playerView.player = exoPlayer

        holder.itemView.playerViewFrameLayout.setOnClickListener {
            if (exoPlayer.isPlaying) {
                exoPlayer.pause()
            } else {
                exoPlayer.play()
            }
        }
    }

    override fun getItemCount() = videosList.size
}