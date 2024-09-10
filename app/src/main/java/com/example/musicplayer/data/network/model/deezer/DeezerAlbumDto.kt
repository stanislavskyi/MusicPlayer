package com.example.musicplayer.data.network.model.deezer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DeezerAlbumDto(
    @SerializedName("cover_xl")
    @Expose
    val image: String
)
