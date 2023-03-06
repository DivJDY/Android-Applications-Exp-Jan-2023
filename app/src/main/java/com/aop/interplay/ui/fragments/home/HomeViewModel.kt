package com.aop.interplay.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import com.aop.interplay.ui.fragments.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    private val _content: MutableLiveData<List<String>> = MutableLiveData()
    val content: LiveData<List<String>> = _content

    fun getContent() {
        val videoURL2 =
            "https://d1ryd0htvizsmh.cloudfront.net/out/v1/a05040e5585940f5a3258249a4e4b931/b893b9d2d65c4c27bc05c6e69eac903c/b628c357315e4a39b6e16691a06358d9/index.m3u8"
        val videoURL =
            "https://d1ryd0htvizsmh.cloudfront.net/out/v1/a0c456c2723b4e08a64b01e562aadc41/b893b9d2d65c4c27bc05c6e69eac903c/b628c357315e4a39b6e16691a06358d9/index.m3u8"

        _content.value = listOf(
            videoURL, videoURL2, videoURL2, videoURL
        )
    }
}