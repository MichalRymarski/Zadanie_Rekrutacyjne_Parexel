package rekru.zr.ui.screen.restaurant.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import rekru.zr.R
import rekru.zr.ui.theme.*

/**
 * Category tags component with selectable chips
 * Matches exact Figma design with Sen font family and proper measurements
 */
@Composable
fun CategoryTags(
    categories: List<String>,
    selectedCategory: String,
    modifier: Modifier = Modifier,
    onCategorySelected: (String) -> Unit = {}
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(categories) { category ->
            CategoryTag(
                text = category,
                isSelected = category == selectedCategory,
                onClick = { onCategorySelected(category) }
            )
        }
    }
}

/**
 * Individual category tag chip
 * Selected state has orange background, unselected has gray border
 */
@Composable
fun CategoryTag(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isSelected) RestaurantOrange else Color.Transparent
    val borderColor = if (isSelected) Color.Transparent else TagBorderGray
    val textColor = if (isSelected) Color.White else TextPrimary

    Box(
        modifier = modifier
            .height(46.dp)
            .clip(RoundedCornerShape(33.dp))
            .background(backgroundColor)
            .then(
                if (!isSelected) {
                    Modifier.border(
                        width = 2.dp,
                        color = borderColor,
                        shape = RoundedCornerShape(33.dp)
                    )
                } else Modifier
            )
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = textColor,
            fontFamily = Sen,
            letterSpacing = (-0.333).sp,
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
fun CategoryTagsPreview() {
    ZRTheme {
        CategoryTags(
            categories = listOf("Burger", "Sandwich", "Pizza", "Sanwich"),
            selectedCategory = "Burger",
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
fun SingleCategoryTagSelectedPreview(){
    ZRTheme {
        CategoryTag(
            text = "Burger",
            isSelected = true,
            onClick = {}
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
fun SingleCategoryTagUnselectedPreview(){
    ZRTheme {
        CategoryTag(
            text = "Burger",
            isSelected = false,
            onClick = {}
        )
    }
}

