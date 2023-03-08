package com.aop.interplay.network.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val videoService: VideoService
){
    suspend fun getHomeVideos() = videoService.getHomeVideos()
}