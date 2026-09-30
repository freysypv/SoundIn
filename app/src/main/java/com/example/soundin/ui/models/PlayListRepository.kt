package com.example.soundin.ui.models

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object PlayListRepository {
    private val _playLists = MutableStateFlow(
        value = listOf(
            Playlist(id = 1, name ="Favourites",     genre = "Rock",      15, "#E91E63", isFavorite = true),
            Playlist(id = 2, name = "Pop Hits",       genre = "Pop",       20, "#2196F3"),
            Playlist(id = 3, name ="Hip Hop Jams",    genre ="Hip Hop",   12, "#FFC107"),
            Playlist(id = 4, name ="Indie Radio",     genre ="Indie",     8,  "#4CAF50"),
            Playlist(id = 5, name ="Classical Music", genre ="Classical", 18, "#9C27B0"),
            Playlist(id = 6, name ="Metal Covers",    genre ="Metal",     25, "#F44336")
        )
    )

    val songs = listOf(
        Song(id = 1, title = "Bohemian Rhapsody",  artist ="Queen",          354, 1),
        Song(id = 2, title = "Blinding Lights",  artist = "The Weekend",     200, 2),
        Song(id = 3, title = "HUMBLE.",           artist = "Kendrick Lamar", 177, 3),
        Song(id = 4, title = "Do I Wanna Know?",  artist = "Arctic Monkeys", 272, 4),
        Song(id = 5, title = "Moonlight Sonata",  artist = "Beethoven",      337, 5),
        Song(id = 6, title = "Master of Puppets", artist = "Metallica",      515, 6)


    )

    val playlists: StateFlow<List<Playlist>> = _playLists.asStateFlow()

    fun toggleFavorite(playlist: Playlist) {
        _playLists.value = _playLists.value.map {
            if (it.id == playlist.id) it.copy(isFavorite = !it.isFavorite)
            else it
        }
    }
    fun deletePlayList(playlist: Playlist){
        _playLists.value = _playLists.value.filter { it.id != playlist.id }
    }
}