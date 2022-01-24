package me.ngima.tdd_android_masterclass

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.ngima.tdd_android_masterclass.model.Playlist

class PlaylistViewModel: ViewModel() {


    val playlists = MutableLiveData<Result<List<Playlist>>>()
}
