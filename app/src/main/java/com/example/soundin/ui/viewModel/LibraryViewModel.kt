package com.example.soundin.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soundin.ui.models.Playlist
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import com.example.soundin.ui.models.PlaylistRepository

class LibraryViewModel : ViewModel() {

    private val _selectedTab = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> = _selectedTab.asStateFlow()

    // Points directly at the repository
    val filteredPlaylists: StateFlow<List<Playlist>> = combine(
        PlaylistRepository.playlists,
        _selectedTab
    ) { playlists, tabIndex ->
        when (tabIndex) {
            1 -> playlists.filter { it.isFavorite }
            else -> playlists
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    fun toggleFavorite(playlist: Playlist) = PlaylistRepository.toggleFavorite(playlist)

    fun deletePlaylist(playlist: Playlist) = PlaylistRepository.deletePlaylist(playlist)

    fun onTabSelected(index: Int) {
        _selectedTab.value = index
    }
}