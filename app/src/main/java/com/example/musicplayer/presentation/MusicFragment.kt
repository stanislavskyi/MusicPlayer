package com.example.musicplayer.presentation

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.domain.Audio
import com.example.musicplayer.presentation.adapters.MusicAdapter

class MusicFragment : Fragment() {

    private lateinit var musicRecyclerView: RecyclerView
    private lateinit var musicAdapter: MusicAdapter

    private val musicList = mutableListOf<Audio>()

    private val openFilePicker = registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        uri?.let {
            displayAudioInfo(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        musicRecyclerView = view.findViewById(R.id.musicRecyclerView)
        musicAdapter = MusicAdapter()
        musicRecyclerView.layoutManager = GridLayoutManager(
            requireContext(),
            3
        )
        musicRecyclerView.adapter = musicAdapter

        val loadMusicButton: Button = view.findViewById(R.id.loadMusicButton)
        loadMusicButton.setOnClickListener {
            openFilePicker.launch(arrayOf("audio/*"))
        }
    }

    private fun displayAudioInfo(uri: Uri) {
        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(requireContext(), uri)

        val title = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE)
        val albumArt = retriever.embeddedPicture

        var bitmap: Bitmap?

        Log.d("MAIN_TAG", "$albumArt")
        if (albumArt != null){
            bitmap = BitmapFactory.decodeByteArray(albumArt, 0, albumArt.size)
        } else{
            bitmap = null
        }

        musicList.add(Audio(title, bitmap))
        musicAdapter.submitList(musicList.toList())

        retriever.release()

    }
}