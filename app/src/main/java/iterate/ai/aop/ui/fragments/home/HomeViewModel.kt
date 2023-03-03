package iterate.ai.aop.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import iterate.ai.aop.ui.fragments.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    private val _content: MutableLiveData<List<String>> = MutableLiveData()
    val content: LiveData<List<String>> = _content

    fun getContent() {
        val videoURL2 =
            "https://d1ryd0htvizsmh.cloudfront.net/out/v1/7bd9b9a4143042f694c6351cbfbfd16e/b893b9d2d65c4c27bc05c6e69eac903c/b628c357315e4a39b6e16691a06358d9/index.m3u8"
        val videoURL =
            "https://d1ryd0htvizsmh.cloudfront.net/out/v1/38377fb93a294bfc937d21406bb00cb7/b893b9d2d65c4c27bc05c6e69eac903c/b628c357315e4a39b6e16691a06358d9/index.m3u8"

        _content.value = listOf(
            videoURL, videoURL2, videoURL2, videoURL
        )
    }
}