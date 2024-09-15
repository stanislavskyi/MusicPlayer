package com.example.musicplayer.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.domain.Music
import com.squareup.picasso.Picasso

class TopMusicAdapter : PagingDataAdapter<Music, TopMusicAdapter.TopViewHolder>(
    TopMusicDiffCallback()
) {

    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
        getItem(position)?.let {
            holder.tvSongTitle.text = it.titleMusic
            holder.tvArtistName.text = it.artistName

            Picasso.get()
                .load(it.imageMusic)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.ivAlbumCover)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_top_music,
            parent,
            false
        )
        return TopViewHolder(view)
    }

    class TopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvArtistName: TextView = itemView.findViewById(R.id.duration)
        val tvSongTitle: TextView = itemView.findViewById(R.id.title)
        val ivAlbumCover: ImageView = itemView.findViewById(R.id.preview)
    }

    class TopMusicDiffCallback : DiffUtil.ItemCallback<Music>() {
        override fun areItemsTheSame(oldItem: Music, newItem: Music): Boolean {
            return oldItem.titleMusic == newItem.titleMusic
        }

        override fun areContentsTheSame(oldItem: Music, newItem: Music): Boolean {
            return oldItem == newItem
        }
    }
}

    //ListAdapter<Music,TopMusicAdapter.TopViewHolder>(TopMusicDiffCallback()) {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top_music, parent, false)
//        return TopViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
//        val item = getItem(position)
//        holder.tvSongTitle.text = item.titleMusic
//        holder.tvArtistName.text = item.artistName
//
//        Picasso.get().load(item.imageMusic).into(holder.ivAlbumCover)
//    }




//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top_music, parent, false)
//        return TopViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
//        val item = items[position]
//        holder.tvSongTitle.text = item.titleMusic
//        holder.tvArtistName.text = item.artistName
//
//        Picasso.get().load(item.imageMusic).into(holder.ivAlbumCover)
//
//
//    }
//
//    override fun getItemCount(): Int = items.size


//        Picasso.get().load(popularPost?.childrenData?.url)
//            .centerCrop()
//            .fit()
//            .placeholder(android.R.drawable.ic_menu_gallery)
//            .error(android.R.drawable.ic_menu_gallery)
//            .into(holder.image)