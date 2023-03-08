package com.aop.interplay.network.remote

import com.aop.interplay.data.network.HomeVideoItem
import com.aop.interplay.network.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface VideoService {

    @GET(Constants.GET_HOME_VIDEOS)
    suspend fun getHomeVideos(): Response<HomeVideoItem>
}