package com.neonusa.apinetworkstatelearning.api

import com.neonusa.apinetworkstatelearning.model.YoutubeApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    // FULL URL
    // https://www.googleapis.com/youtube/v3/search?key=AIzaSyAGz9sVOYHJ0X7K4kTxHPK4OcnrMmmyBb8&channelId=UCLyVPPCkclkXM8KPLeZvHvg&maxResults=20

    // response diatas memiliki 6 key. namun kita hanya akan mengambil satu key saja yaitu item
    // dari response tersebut (buka url diatas biar lebih paham dan buka YoutubeApiResponse)

    @GET("youtube/v3/search")
    suspend fun getChannelVideos(
        @Query("part") part: String = "snippet",
        @Query("order") order: String = "date",
        @Query("channelId") channelId: String = "UCLyVPPCkclkXM8KPLeZvHvg",
        @Query("maxResults") maxResults: Int = 20,
        @Query("key") key: String = "AIzaSyAGz9sVOYHJ0X7K4kTxHPK4OcnrMmmyBb8"
        ): Response<YoutubeApiResponse>

//    @GET("youtube/v3/playlistItems")
//    suspend fun getPlaylistVideos(
//        @Query("part") part: String = "snippet",
//        @Query("playlistId") playlistId: String = PLAYLIST_ID,
//        @Query("maxResults") maxResults: Int = 20,
//        @Query("key") key: String = "AIzaSyAGz9sVOYHJ0X7K4kTxHPK4OcnrMmmyBb8"
//    ): Response<YoutubePlaylistResponse>
//
//    @GET("youtube/v3/search")
//    suspend fun getLiveVideos(
//        @Query("part") part: String = "snippet",
//        @Query("type") type: String = "video",
//        @Query("channelId") channelId: String = CHANNEL_ID,
//        @Query("eventType") eventType: String = "live",
//        @Query("maxResults") maxResults: Int = 20,
//        @Query("key") key: String = GOOGLE_YOUTUBE_API_KEY
//    ): Response<YoutubeApiResponse>

}