package com.example.soundin.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Shapes as Shapes1

private val DarkColorScheme = darkColorScheme(
    primary = SoundInPrimaryDark,
    secondary = SoundInSecondaryDark,
    background = SoundInBackgroundDark,
    onPrimary = SoundInOnPrimaryDark,
    onSurface = SoundInSurfaceDark,
    onError = SoundInError
)

private val LightColorScheme = lightColorScheme(
    primary = SoundInPrimary,
    secondary = SoundInSecondary,
    error = SoundInError,
    background = SoundInBackground,
    surface = SoundInSurface,
    onPrimary = SoundInOnPrimary,
    onBackground = SoundInOnBackground,
    onSurface = SoundInOnSurface,

)

@Composable
fun SoundinTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    // set alse so the app uses our colors, ont the system dynamic colors
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = (when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }).apply {

        MaterialTheme(
            colorScheme = this,
            typography = Typography,
            shapes = Shapes(
                extraSmall = RoundedCornerShape(size =8.dp),
                small = RoundedCornerShape(size =12.dp),
                medium = RoundedCornerShape(size = 16.dp),
                large = RoundedCornerShape(size =24.dp),
                extraLarge = RoundedCornerShape(size =32.dp)
            ),
            content = content
        )
    }
}