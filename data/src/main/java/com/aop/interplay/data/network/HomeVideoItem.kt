package com.aop.interplay.data.network

import com.google.gson.annotations.SerializedName

data class HomeVideoItem(
    val homePosts: List<HomePost>?
)

data class HomePost(
    @SerializedName("postid") val postId: String,
    @SerializedName("name") val name: String,
    @SerializedName("username") val userName: String,
    @SerializedName("description") val description: String,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
)
