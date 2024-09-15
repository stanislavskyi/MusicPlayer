package com.example.musicplayer.presentation.deezer

data class Track(
    val id: Long,
    val title: String,
    val duration: Int,
    val link: String,
    val preview: String,
    val md5_image: String,
    val album: Album
)
