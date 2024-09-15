package com.example.musicplayer.presentation.deezer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn

class TrackViewModel : ViewModel() {
    val tracks = Pager(PagingConfig(pageSize = 20)) {
        TrackPagingSource(RetrofitInstance.api)
    }.flow.cachedIn(viewModelScope)
}