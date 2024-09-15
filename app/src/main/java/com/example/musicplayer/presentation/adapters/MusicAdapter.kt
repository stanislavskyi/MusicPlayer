package com.example.musicplayer.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.domain.Music

class MusicAdapter : ListAdapter<String, MusicAdapter.MusicViewHolder>(MusicDiffCallback()) {

    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val musicTitle: TextView = itemView.findViewById(R.id.musicTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.musicTitle.text = getItem(position)
    }

    class MusicDiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}

//class MusicAdapter : ListAdapter<Music, MusicAdapter.MusicViewHolder>(MusicDiffCallback()) {
//
//    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val musicTitle: TextView = itemView.findViewById(R.id.title)
//    }
//
//    class MusicDiffCallback : DiffUtil.ItemCallback<Music>() {
//        override fun areItemsTheSame(oldItem: Music, newItem: Music): Boolean {
//            return oldItem.titleMusic == newItem.titleMusic
//        }
//
//        override fun areContentsTheSame(oldItem: Music, newItem: Music): Boolean {
//            return oldItem == newItem
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(
//            R.layout.item_top_music,
//            parent,
//            false
//        )
//        return MusicViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
//        getItem(position)?.let {
//            holder.musicTitle.text = it.titleMusic
//
//        }
//    }
//
//
//}