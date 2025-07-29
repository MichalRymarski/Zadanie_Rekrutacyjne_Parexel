package rekru.zr.ui.screen.restaurant.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import rekru.zr.R
import rekru.zr.ui.theme.PickedWhite
import rekru.zr.ui.theme.UnpickedWhite
import rekru.zr.ui.theme.ZRTheme
import kotlin.reflect.KFunction1

/**
 * Restaurant image carousel with auto-scroll and manual swipe functionality
 */
@Composable
fun RestaurantImageCarousel(
    modifier: Modifier = Modifier,
    currentPage: Int = 0,
    totalPages: Int = 5,
    onPageChanged: (Int) -> Unit = {},
    setAutoscroll: (Boolean) -> Unit = {},
) {
    val pagerState = rememberPagerState(
        initialPage = currentPage,
        pageCount = { totalPages }
    )

    LaunchedEffect(currentPage) {
        if (pagerState.currentPage != currentPage) {
            pagerState.animateScrollToPage(currentPage)
        }
    }

    LaunchedEffect(pagerState.currentPage) {
        onPageChanged(pagerState.currentPage)
    }

    Box {
        HorizontalPager(
            state = pagerState,
            modifier = modifier.pointerInput(pagerState) {
                detectHorizontalDragGestures(
                    onDragStart = { setAutoscroll(false) },
                    onDragEnd = { setAutoscroll(true) }
                ) { _, _ -> }
            }
        ) {
            Image(
                painter = painterResource(R.drawable.top_image),
                contentDescription = "Restaurant image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(329.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 24.dp,
                            bottomEnd = 24.dp
                        )
                    ),
                contentScale = ContentScale.Crop
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.3.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(totalPages) { index ->
                val isSelected = index == currentPage

                ImageIndicator(isSelected)
            }
        }
    }
}

@Composable
private fun ImageIndicator(isSelected: Boolean) {
    if (isSelected) {
        Icon(
            painter = painterResource(R.drawable.picked),
            contentDescription = "Current Picture indicator",
            tint = PickedWhite
        )
    } else {
        Icon(
            painter = painterResource(R.drawable.unpicked),
            contentDescription = "Current Picture indicator",
            tint = UnpickedWhite
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Preview(showBackground = true, device = Devices.PIXEL_4)
@Preview(showBackground = true, device = Devices.PIXEL_7)
@Composable
fun RestaurantImageCarouselPreviewNexus5() {
    ZRTheme {
        RestaurantImageCarousel()
    }
}
