package com.example.lesson13.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson13.R

class SongAdapter(val listSong: ArrayList<Song>,private val clickSongItem: (Song) -> Unit) : RecyclerView.Adapter<SongAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = listSong[position]
        holder.txtArtist.text = song.artist
        holder.txtTitle.text = song.title
        holder.imgCover.setImageResource(R.drawable.disc1)
        holder.itemView.setOnClickListener {
            clickSongItem(song)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById<TextView>(R.id.txtTitleSongRow)
        val txtArtist = itemView.findViewById<TextView>(R.id.txtArtistSongRow)
        val imgCover = itemView.findViewById<ImageView>(R.id.imgCoverSongRow)
    }
}
