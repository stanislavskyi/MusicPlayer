package com.example.musicplayer.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.musicplayer.data.mapper.MusicMapper
import com.example.musicplayer.data.network.ApiService
import com.example.musicplayer.domain.Music

class MusicPagingSource(
    private val apiService: ApiService
): PagingSource<Int, Music>() {
    override fun getRefreshKey(state: PagingState<Int, Music>): Int? {
        TODO("Not yet implemented")
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Music> {
        return try {
            val nextPageNumber  =  params.key ?: 0
            val response = apiService.getTopTracks(
                index = nextPageNumber,
                limit = params.loadSize
            )


            val tracks = response.tracks.deezerListTrack.map { MusicMapper.mapDtoToEntity(it) }
            LoadResult.Page(
                data = tracks,
                prevKey = if(nextPageNumber == 0) null else nextPageNumber - params.loadSize,
                nextKey = if (tracks.isEmpty()) null else nextPageNumber + params.loadSize
            )
        } catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}