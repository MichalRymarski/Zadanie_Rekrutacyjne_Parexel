package rekru.zr.ui.screen.restaurant.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import rekru.zr.R
import rekru.zr.ui.theme.Sen
import rekru.zr.ui.theme.TextPrimary
import rekru.zr.ui.theme.ZRTheme

/**
 * Displays section headers with an amount of menu items like "Burger (10)"
 */
@Composable
fun SectionTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        color = TextPrimary,
        fontFamily = Sen,
        modifier = modifier.fillMaxWidth()
    )
}


@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
fun SectionTitlePreview() {
    ZRTheme {
        SectionTitle(
            title = "Burger (10)"
        )
    }
}


