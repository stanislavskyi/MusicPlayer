package com.example.musicplayer.presentation.deezer

data class TrackResponse(
    val data: List<Track>,
    val total: Int
)