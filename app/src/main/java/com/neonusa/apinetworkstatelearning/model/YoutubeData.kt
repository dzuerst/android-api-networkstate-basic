package com.neonusa.apinetworkstatelearning.model

data class YoutubeData(
    val etag: String,
    val id: Id,
    val kind: String,
    val snippet: Snippet
)

data class Id(
    val kind: String,
    val videoId: String
)

data class Snippet(
    val channelId: String,
    val channelTitle: String,
    val description: String,
    val liveBroadcastContent: String,
    val publishTime: String,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String
)

data class Default(
    val height: Int,
    val url: String,
    val width: Int
)

data class High(
    val height: Int,
    val url: String,
    val width: Int
)
data class Medium(
    val height: Int,
    val url: String,
    val width: Int
)

data class Thumbnails(
    val default: Default,
    val high: High,
    val medium: Medium
)
