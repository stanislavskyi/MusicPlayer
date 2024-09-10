package com.example.musicplayer.data.network

import com.example.musicplayer.data.network.model.deezer.DeezerResponseDto
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("playlist/$QUERY_PARAM_TOP_GLOBAL_TRACKS")
    suspend fun getTopTracks(
        @Query("index") index: Int,
        @Query("limit") limit: Int
    ): DeezerResponseDto

    companion object {
        private const val QUERY_PARAM_TOP_GLOBAL_TRACKS = "3155776842"
    }
}