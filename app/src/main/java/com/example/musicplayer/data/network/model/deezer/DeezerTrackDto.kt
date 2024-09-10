package com.example.musicplayer.data.network.model.deezer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DeezerTrackDto(
    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("album")
    @Expose
    val album: DeezerAlbumDto,

    @SerializedName("artist")
    @Expose
    val artist: DeezerArtistDto
)
