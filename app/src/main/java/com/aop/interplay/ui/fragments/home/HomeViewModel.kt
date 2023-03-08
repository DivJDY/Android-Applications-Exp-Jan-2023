package com.aop.interplay.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aop.interplay.network.remote.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import com.aop.interplay.ui.fragments.BaseViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val networkRepository: NetworkRepository
) : BaseViewModel() {

    private val _content: MutableLiveData<List<String>> = MutableLiveData()
    val content: LiveData<List<String>> = _content

    fun getHomeVideos() {
        viewModelScope.launch {
            networkRepository.getHomeVideos().collectLatest { values ->
                _content.value = values.data?.homeUrls.orEmpty()
            }
        }
    }
}