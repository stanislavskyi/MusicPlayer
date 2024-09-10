package com.example.musicplayer.data.mapper

import com.example.musicplayer.data.network.model.deezer.DeezerTrackDto
import com.example.musicplayer.domain.Music

class MusicMapper {
    companion object{
        fun mapDtoToEntity(dto: DeezerTrackDto) = Music(
            artistName = dto.artist.name,
            titleMusic = dto.title,
            imageMusic = dto.album.image
        )
    }
}