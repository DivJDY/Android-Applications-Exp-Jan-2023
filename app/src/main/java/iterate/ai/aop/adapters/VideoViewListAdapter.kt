package iterate.ai.aop.adapters

import android.content.Context
import android.graphics.Point
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import iterate.ai.aop.R
import kotlinx.android.synthetic.main.adapter_video_view_item.view.*

class VideoViewListAdapter(private val videosList: List<String>) :
    RecyclerView.Adapter<VideoViewListAdapter.ViewHolder>() {

    private val mStoredMedia: SparseArray<String> = SparseArray<String>()
    private val mStoredPlayers: SparseArray<ExoPlayer> = SparseArray<ExoPlayer>()
    private val mStoredPlayerView: SparseArray<PlayerView> = SparseArray<PlayerView>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var videoSurfaceDefaultHeight = 0
        private var screenDefaultHeight = 0
        private lateinit var videoPlayerView: PlayerView

        fun setVideoItemData(
            videoURL: String,
            position: Int,
            storedMedia: SparseArray<String>,
            storedPlayer: SparseArray<ExoPlayer>,
            storedPlayerView: SparseArray<PlayerView>
        ) {

            storedMedia.append(position, videoURL)
            storedPlayerView.append(position,getVideoSource(itemView.context))
            storedPlayer.append(position, getVPlayer(itemView.context))


        }

        private fun getVPlayer(context: Context): ExoPlayer {

            val exoPlayer = ExoPlayer.Builder(context)
                .build()
            return exoPlayer
        }

        private fun getVideoSource(mContext: Context): PlayerView {
            val display =(mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
            val point = Point()
            display.getSize(point)

            videoSurfaceDefaultHeight = point.x
            screenDefaultHeight = point.y
            videoPlayerView = PlayerView(mContext)
            videoPlayerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
            videoPlayerView.useController = false
            videoPlayerView.setShowBuffering(PlayerView.SHOW_BUFFERING_WHEN_PLAYING)
            return videoPlayerView
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_video_view_item, parent, false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setVideoItemData(
            videosList[position],
            position,
            mStoredMedia,
            mStoredPlayers,
            mStoredPlayerView
        )
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)

        val adapterPosition = holder.adapterPosition
        val indexOfChild = holder.itemView.playerViewFrameLayout.indexOfChild(mStoredPlayerView.get(adapterPosition))

        if (indexOfChild >= 0)
        {
            //remove the player view from parent view and stop player
            holder.itemView.playerViewFrameLayout.removeViewAt(indexOfChild)
            mStoredPlayers.get(adapterPosition).stop()
        }
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        super.onViewAttachedToWindow(holder)

        val adapterPosition = holder.adapterPosition

        //get the existing instances of exoplayer and exoplayer view
        val playerView = mStoredPlayerView.get(adapterPosition)
        val exoPlayer: ExoPlayer =mStoredPlayers.get(adapterPosition)

        val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
        val hlsMediaSource = HlsMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(mStoredMedia.get(adapterPosition)))

        exoPlayer.setMediaSource(hlsMediaSource)

        exoPlayer.repeatMode= Player.REPEAT_MODE_ONE
        exoPlayer.playWhenReady = true
        exoPlayer.prepare()

        playerView.player = exoPlayer
        //add player view again to parent
        holder.itemView.playerViewFrameLayout.addView(playerView)

        holder.itemView.playerViewFrameLayout.setOnClickListener {

            if(exoPlayer.isPlaying){
                exoPlayer.pause()
            }else{
                exoPlayer.playWhenReady=true
                exoPlayer.playbackState
            }
        }

        //add show more and show less code here
        holder.itemView.video_description_tv.setOnClickListener{
            val longText = holder.itemView.video_description_tv.toString()
            makeTextViewResizable(longText, 1, "View More", true)

        }

    }

    private fun makeTextViewResizable(textParkdescription: Any, i: Int, s: String, b: Boolean) {

    }

    override fun getItemCount(): Int {
        return videosList.size
    }


}