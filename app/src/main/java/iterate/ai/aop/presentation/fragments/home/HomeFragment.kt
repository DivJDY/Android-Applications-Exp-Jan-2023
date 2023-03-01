package iterate.ai.aop.presentation.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import iterate.ai.aop.BaseFragment
import iterate.ai.aop.R
import iterate.ai.aop.databinding.ActivityMainBinding
import iterate.ai.aop.presentation.adapters.VideoViewListAdapter
import kotlinx.android.synthetic.main.fragment_home.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         // val videoURL3 = "https://bitmovin-a.akamaihd.net/content/MI201109210084_1/mpds/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.mpd"
        val videoURL2 = "https://d1ryd0htvizsmh.cloudfront.net/out/v1/7bd9b9a4143042f694c6351cbfbfd16e/b893b9d2d65c4c27bc05c6e69eac903c/b628c357315e4a39b6e16691a06358d9/index.m3u8"
        val videoURL =
            "https://d1ryd0htvizsmh.cloudfront.net/out/v1/38377fb93a294bfc937d21406bb00cb7/b893b9d2d65c4c27bc05c6e69eac903c/b628c357315e4a39b6e16691a06358d9/index.m3u8"
        //prepareExoPlayer(view, videoURL)

        val videosList = ArrayList<String>()
        videosList.add(videoURL)
        videosList.add(videoURL2)
        videosList.add(videoURL2)
        videosList.add(videoURL)
        val adapter = VideoViewListAdapter(videosList)
        view_pager.adapter = adapter
    }


}