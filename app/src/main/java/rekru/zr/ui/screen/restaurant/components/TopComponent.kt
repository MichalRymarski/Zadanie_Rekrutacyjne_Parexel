package rekru.zr.ui.screen.restaurant.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rekru.zr.R
import rekru.zr.ui.theme.PickedWhite
import rekru.zr.ui.theme.TextPrimary
import rekru.zr.ui.theme.ZRTheme

/**
 * Component that hosts the two buttons at the top
 */
@Composable
fun TopComponent(
    onBackClick: () -> Unit,
    onMenuClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp)
    ) {
        Box(
            modifier = Modifier
                .size(45.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = CircleShape,
                    ambientColor = Color.Black.copy(alpha = 0.1f),
                    spotColor = Color.Black.copy(alpha = 0.1f)
                )
                .clip(CircleShape)
                .background(Color.White)
                .clickable { onBackClick() }
                .align(Alignment.CenterStart),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.width(5.dp).height(10.dp),
                painter = painterResource(R.drawable.back),
                contentDescription = "Current Picture indicator",
                tint = TextPrimary
            )
        }

        Box(
            modifier = Modifier
                .size(45.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = CircleShape,
                    ambientColor = Color.Black.copy(alpha = 0.1f),
                    spotColor = Color.Black.copy(alpha = 0.1f)
                )
                .clip(CircleShape)
                .background(Color.White)
                .clickable { onMenuClick() }
                .align(Alignment.CenterEnd),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(R.drawable.more),
                contentDescription = "Current Picture indicator",
                tint = TextPrimary
            )
        }
    }
}


@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
fun TopComponentPreviewNexus5() {
    ZRTheme {
        TopComponent(
            onBackClick = {},
            onMenuClick = {},
            modifier = Modifier.padding(24.dp)
        )
    }
}

