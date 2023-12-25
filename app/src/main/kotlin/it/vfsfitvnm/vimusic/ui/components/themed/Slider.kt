package it.vfsfitvnm.vimusic.ui.components.themed

import androidx.annotation.IntRange
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import it.vfsfitvnm.vimusic.ui.styling.LocalAppearance

// TODO: due to changes in the Material Slider there are unknown glitches that occur

@Composable
fun Slider(
    state: Float,
    onSlide: (Float) -> Unit,
    onSlideCompleted: () -> Unit,
    range: ClosedFloatingPointRange<Float>,
    modifier: Modifier = Modifier,
    @IntRange(from = 0) steps: Int = 0
) {
    val (colorPalette) = LocalAppearance.current

    androidx.compose.material3.Slider(
        value = state,
        onValueChange = { onSlide(it)},
        onValueChangeFinished = onSlideCompleted,
        valueRange = range,
        steps = steps,
        modifier = modifier,
        colors = SliderDefaults.colors(
            thumbColor = colorPalette.onAccent,
            activeTrackColor = colorPalette.accent,
            inactiveTrackColor = colorPalette.text.copy(alpha = 0.75f)
        )
    )
}
