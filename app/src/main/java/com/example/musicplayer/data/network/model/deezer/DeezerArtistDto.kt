package com.example.musicplayer.data.network.model.deezer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DeezerArtistDto(
    @SerializedName("name")
    @Expose
    val name: String
)
