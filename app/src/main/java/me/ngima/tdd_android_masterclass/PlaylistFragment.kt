package me.ngima.tdd_android_masterclass

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import me.ngima.tdd_android_masterclass.databinding.FragmentPlaylistBinding
import me.ngima.tdd_android_masterclass.model.Playlist

/**
 * A fragment representing a list of Items.
 */
class PlaylistFragment : Fragment() {

    lateinit var viewModel: PlaylistViewModel
    lateinit var viewModelFactory: PlaylistViewModelFactory
    private var _binding: FragmentPlaylistBinding? = null
    private val binding: FragmentPlaylistBinding
        get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPlaylistBinding.inflate(inflater, container, false)

        setupViewModel()

        return binding.root
    }

    private fun setupViewModel() {
        viewModelFactory = PlaylistViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[PlaylistViewModel::class.java]
    }


    private fun observe() {
        viewModel.playlists.observe(this) { playlist ->

            if (playlist.getOrNull() != null)
                setupList(playlist.getOrNull()!!)
            else {
                //TODO
            }
        }
    }

    private fun setupList(playlist: List<Playlist>) {
        with(binding.playlistList) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyPlaylistRecyclerViewAdapter(playlist)
        }
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            PlaylistFragment().apply {

            }
    }
}