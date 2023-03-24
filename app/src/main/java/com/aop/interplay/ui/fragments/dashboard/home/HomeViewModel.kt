package com.aop.interplay.ui.fragments.dashboard.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aop.interplay.data.network.HomePost
import com.aop.interplay.network.remote.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import com.aop.interplay.ui.fragments.BaseViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : BaseViewModel(networkRepository) {

    private val _content: MutableLiveData<List<HomePost>> = MutableLiveData()
    val content: LiveData<List<HomePost>> = _content

    fun getPosts() {
        viewModelScope.launch {
            networkRepository.getPosts().collectLatest { values ->
                _content.value = values.data?.homeScreenPosts?.post.orEmpty()
            }
        }
    }
}