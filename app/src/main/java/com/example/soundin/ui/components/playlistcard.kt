package com.example.soundin.ui.components

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.soundin.ui.models.Playlist

@Composable
fun PlaylistCard(
    playlist: Playlist,
    onClick: () -> Unit,
    onLongClick: () -> Unit,
){

    Card(modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1f)
        .combinedClickable(
            onClick = onClick,
            onLongClick = onLongClick

    ),
      elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    )
        {
            Column(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(Color(playlist.colorHex.toColorInt())),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.MusicNote,
                        contentDescription = "Playlist Cover",
                        tint = White.copy(alpha = 0.3f),
                            modifier = Modifier.size(32.dp)
                    )
                    Column (modifier = Modifier.padding(16.dp))
                    {
                        Text(
                            text = playlist.name,
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "${playlist.songCount} songs",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant


                        )
                    }

                }
            }

        }
}


//@Preview(showBackground = true, widthDp = 200)
//@Composable
//fun PlaylistCardPreview() {
//    SoundInTheme {
//        Box(modifier = Modifier.padding(16.dp)) {
//            PlaylistCard(
//                playlist = Playlist(
//                    id        = 1,
//                    name      = "Rock Classics",
//                    genre     = "Rock",
//                    songCount = 15,
//                    colorHex  = "#E91E63"
//                ),
//                onClick     = {},
//                onLongClick = {}
//            )
//        }
//    }
//}