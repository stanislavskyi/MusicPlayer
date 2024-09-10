package com.example.musicplayer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.musicplayer.data.network.ApiFactory
import com.example.musicplayer.data.network.paging.MusicPagingSource

class MusicViewModel : ViewModel() {
    val pager = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { MusicPagingSource(ApiFactory.apiService) }
    ).flow.cachedIn(viewModelScope)
}