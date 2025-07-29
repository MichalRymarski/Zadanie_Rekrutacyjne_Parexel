package rekru.zr.ui.screen.restaurant.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rekru.zr.ui.theme.*

enum class FoodCategory(private val displayName: String) {
    Burger("Burger"),
    Sandwich("Sandwich"),
    Pizza("Pizza"),
    Sanwich("Sanwich");

    override fun toString(): String = displayName
}

/**
 * Category tags component with selectable chips
 */
@Composable
fun CategoryTags(
    selectedCategory: FoodCategory,
    modifier: Modifier = Modifier,
    onCategorySelected: (FoodCategory) -> Unit = {},
) {
    val categories = FoodCategory.entries

    LazyRow(
        modifier = modifier.fillMaxWidth(),
    ) {
        items(categories) { category ->
            CategoryTag(
                text = category.toString(),
                isSelected = category == selectedCategory,
                onClick = { onCategorySelected(category) }
            )
            if (category != categories.last()) {
                Spacer(Modifier.widthIn(10.dp))
            }
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
        // The most problematic component. The word inside has a different padding depending on how tall and how wide is the word, and to my knowledge there's no
        // min padding value given anywhere in the Figma design
    TextButton(
        onClick = onClick,
        modifier = modifier.heightIn(46.dp),
        border = BorderStroke( width = 2.dp, color = borderColor),
        colors = ButtonDefaults.buttonColors().copy(containerColor = backgroundColor),
        contentPadding = PaddingValues(horizontal = 20.dp),
        shape = RoundedCornerShape(33.dp),
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = textColor,
            fontFamily = Sen,
            letterSpacing = (-0.333).sp,
            maxLines = 1,
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
            selectedCategory = FoodCategory.Burger,
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
fun SingleCategoryTagSelectedPreview() {
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
fun SingleCategoryTagUnselectedPreview() {
    ZRTheme {
        CategoryTag(
            text = "Burger",
            isSelected = false,
            onClick = {}
        )
    }
}

