package iterate.ai.aop.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import iterate.ai.aop.adapters.VideoViewListAdapter
import iterate.ai.aop.databinding.FragmentHomeBinding
import iterate.ai.aop.ui.fragments.BaseFragment

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    
    private var adapter: VideoViewListAdapter? = null
    private var listData: MutableList<String> = mutableListOf()

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
    
    private fun initViews() {
        adapter = VideoViewListAdapter(listData)
        binding.viewPager.adapter = adapter
        viewModel.getContent()
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