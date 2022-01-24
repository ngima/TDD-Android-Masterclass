package me.ngima.tdd_android_masterclass

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import me.ngima.tdd_android_masterclass.databinding.PlaylistItemBinding
import me.ngima.tdd_android_masterclass.model.Playlist

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyPlaylistRecyclerViewAdapter(
    private val values: List<Playlist>
) : RecyclerView.Adapter<MyPlaylistRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            PlaylistItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: PlaylistItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val playlistName: TextView = binding.playlistName
        val playlistCategory: TextView = binding.playlistCategory


        fun bind(playlist: Playlist){
            playlistName.text = playlist.name
            playlistCategory.text = playlist.category
        }
    }

}