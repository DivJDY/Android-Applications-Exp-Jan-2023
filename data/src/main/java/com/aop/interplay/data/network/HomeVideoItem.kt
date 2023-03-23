package com.aop.interplay.data.network

import com.google.gson.annotations.SerializedName

data class HomeVideoItem(
    @SerializedName("homeScreenPosts") val homeScreenPosts: HomeScreenPost,
    @SerializedName("success") val success: Boolean
)

data class HomeScreenPost(
    @SerializedName("hasMore") val hasMore: Boolean,
    @SerializedName("post") val post: List<HomePost>,
    @SerializedName("startingAfter") val startingAfter: Int
)

data class HomePost(
    @SerializedName("pk") val userName: String,
    @SerializedName("sk") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("hashtag") val tags: List<String>,
    @SerializedName("type") val type: Type?,
    @SerializedName("createdTime") val createdTime: String,
    @SerializedName("createdBy") val createdBy: CreatedBy,
    @SerializedName("videoInfo") val videoInfo: VideoInfo,
    @SerializedName("count") val count: Count,
)

data class Type(
    @SerializedName("name") val name: String?,
    @SerializedName("badge") val badge: String?
)

data class CreatedBy(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("bioImage") val bioImage: String
)

data class VideoInfo(
    @SerializedName("url") val url: String,
    @SerializedName("thumbnailUrl") val thumbnailUrl: String,
    @SerializedName("duration") val duration: String
)

data class Count(
    @SerializedName("views") val views: String,
    @SerializedName("likes") val likes: String,
    @SerializedName("bookmarks") val bookmarks: String,
)
