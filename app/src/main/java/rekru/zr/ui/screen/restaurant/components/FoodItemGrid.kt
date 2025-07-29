package rekru.zr.ui.screen.restaurant.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rekru.zr.ui.theme.ZRTheme
import rekru.zr.utils.mapOfFoodItems

data class FoodItem(
    val category: FoodCategory,
    val name: String,
    val description: String,
    val price: String,
)

/**
 * Grid layout for food items
 */
@Composable
fun FoodItemGrid(
    selectedCategory: FoodCategory,
    foodItems: Map<FoodCategory, List<FoodItem>> = emptyMap(),
    modifier: Modifier = Modifier,
    onItemAdd: (FoodItem) -> Unit = {},
) {
    val items = foodItems[selectedCategory].orEmpty()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxWidth().padding(bottom = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(21.dp),
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {
        items(items) { item ->
            FoodItemCard(
                item = item,
                onAddClick = { onItemAdd(item) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
fun FoodItemGridPreview() {
    ZRTheme {
        FoodItemGrid(
            foodItems = mapOfFoodItems(),
            modifier = Modifier.padding(24.dp),
            selectedCategory = FoodCategory.Burger
        )
    }
}
