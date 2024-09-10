package com.example.musicplayer.data.network.model.deezer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DeezerResponseDto(
    @SerializedName("tracks")
    @Expose
    val tracks: DeezerTracksDto
)
