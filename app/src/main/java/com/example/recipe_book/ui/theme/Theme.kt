package com.example.recipe_book.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Mauve40,
    onPrimary = Color.White,
    primaryContainer = Lavender95,
    onPrimaryContainer = Color(0xFF493C4D),

    secondary = Color(0xFFB5A2BC),
    onSecondary = Color(0xFF302735),
    secondaryContainer = Color(0xFFEDE3EF),
    onSecondaryContainer = Color(0xFF493C4D),

    tertiary = Color(0xFFAC8170),
    onTertiary = Color.White,
    tertiaryContainer = Peach80,
    onTertiaryContainer = Color(0xFF493027),

    background = BackgroundLight,
    onBackground = OnBackgroundLight,

    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    surfaceVariant = Color(0xFFEDE5EE),
    onSurfaceVariant = Color(0xFF655967),

    outline = OutlineLight,
    outlineVariant = Color(0xFFECE3ED)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD6C4DC),
    onPrimary = Color(0xFF35283B),
    primaryContainer = Color(0xFF5E4B65),
    onPrimaryContainer = Color(0xFFF3EDF4),

    secondary = Color(0xFFC8B5CE),
    onSecondary = Color(0xFF352D38),
    secondaryContainer = Color(0xFF514357),
    onSecondaryContainer = Color(0xFFEDE3EF),

    tertiary = Color(0xFFF2C9B7),
    onTertiary = Color(0xFF493027),
    tertiaryContainer = Color(0xFF684B40),
    onTertiaryContainer = Color(0xFFFFE8DE),

    background = Color(0xFF1E191F),
    onBackground = Color(0xFFF3EDF4),

    surface = Color(0xFF27212A),
    onSurface = Color(0xFFF3EDF4),
    surfaceVariant = Color(0xFF39313D),
    onSurfaceVariant = Color(0xFFD0C3D2),

    outline = Color(0xFF857689),
    outlineVariant = Color(0xFF49404D)
)

@Composable
fun RecipebookTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}