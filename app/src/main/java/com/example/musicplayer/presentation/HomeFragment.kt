package com.example.musicplayer.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.data.mapper.MusicMapper
import com.example.musicplayer.data.network.ApiFactory
import com.example.musicplayer.domain.Carousel
import com.example.musicplayer.domain.Music
import com.example.musicplayer.presentation.adapters.CarouselAdapter
import com.example.musicplayer.presentation.adapters.CategoryAdapter
import com.example.musicplayer.presentation.adapters.TopMusicAdapter
import com.example.musicplayer.presentation.viewmodel.MusicViewModel
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {

    private val viewModel: MusicViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.carouselRecyclerView)
        recyclerView.layoutManager = CarouselLayoutManager()

        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        val items = listOf(
            Carousel(R.drawable.ic_launcher_background),
            Carousel(R.drawable.ic_launcher_background),
            Carousel(R.drawable.ic_launcher_background),
            Carousel(R.drawable.ic_launcher_background),
            Carousel(R.drawable.ic_launcher_background),
            Carousel(R.drawable.ic_launcher_background)
        )

        recyclerView.adapter = CarouselAdapter(items)

        val recyclerViewCategory = view.findViewById<RecyclerView>(R.id.recyclerViewCategory)
        recyclerViewCategory.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerViewCategory.adapter = CategoryAdapter(items)

//        val recyclerViewTopMusic = view.findViewById<RecyclerView>(R.id.recycleViewTopMusic)
//        recyclerViewTopMusic.layoutManager = LinearLayoutManager(
//            requireContext(),
//            LinearLayoutManager.VERTICAL,
//            false
//        )
//
//        val topMusicAdapter = TopMusicAdapter()
//        recyclerViewTopMusic.adapter = topMusicAdapter
//
//        lifecycleScope.launch {
//            val response = ApiFactory.apiService.getTopTracks()
//            Log.d("HomeFragment", response.toString())
//
//            val topTracks = response.tracks.deezerListTrack
//            Log.d("HomeFragment", "$topTracks")
//
//            val entity = topTracks.map { MusicMapper.mapDtoToEntity(it) }
//            topMusicAdapter.submitList(entity)
//        }

        val recyclerViewTopMusic = view.findViewById<RecyclerView>(R.id.recycleViewTopMusic)
        recyclerViewTopMusic.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        val topMusicAdapter = TopMusicAdapter()
        recyclerViewTopMusic.adapter = topMusicAdapter

        lifecycleScope.launch {
            viewModel.pager.collectLatest { pagingData ->
                topMusicAdapter.submitData(pagingData)
            }
        }
    }
}

/*
val musics = listOf(
    Music("Кишлак", "Ты улыбаешься?",R.drawable.ic_launcher_background),
    Music("Кишлак", "Сильнее соли",R.drawable.ic_launcher_background),
    Music("Кишлак", "Движение",R.drawable.ic_launcher_background),
    Music("Кишлак", "Lv",R.drawable.ic_launcher_background),
    Music("Кишлак", "21",R.drawable.ic_launcher_background),
    Music("Кишлак", "Дрочу на твои фото",R.drawable.ic_launcher_background),
    Music("Кишлак", "Ты улыбаешься?",R.drawable.ic_launcher_background),
    Music("Кишлак", "Аня Долгова",R.drawable.ic_launcher_background),
    Music("Кишлак", "Зачем я сегодня проснулся",R.drawable.ic_launcher_background),
    Music("Кишлак", "Не забирай меня домой",R.drawable.ic_launcher_background),
    Music("Кишлак", "Сколько стоит счастье",R.drawable.ic_launcher_background),
    Music("Кишлак", "Аня Долгова",R.drawable.ic_launcher_background),
    Music("Кишлак", "Не в адеквате",R.drawable.ic_launcher_background),
    Music("Кишлак", "Слепые",R.drawable.ic_launcher_background),
    Music("Кишлак", "Танцы на Vy Большого пса",R.drawable.ic_launcher_background),
    Music("Кишлак", "Движение",R.drawable.ic_launcher_background),
    Music("Кишлак", "Селфхарм",R.drawable.ic_launcher_background),
    Music("Кишлак", "Давай поправимся",R.drawable.ic_launcher_background),
)

recyclerViewTopMusic.adapter = TopMusicAdapter(musics)
*/