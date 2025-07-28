package rekru.zr.ui.screen.restaurant.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rekru.zr.ui.theme.ZRTheme

data class FoodItem(
    val id: String,
    val name: String,
    val description: String,
    val price: String,
)

/**
 * Grid layout for food items
 */
@Composable
fun FoodItemGrid(
    modifier: Modifier = Modifier,
    onItemAdd: (String) -> Unit = {}
) {
    val foodItems = listOf(
        FoodItem(
            id = "1",
            name = "Burger Ferguson",
            description = "Spicy restaurant",
            price = "$40",
        ),
        FoodItem(
            id = "2",
            name = "Rockin' Burgers",
            description = "Cafecafachino",
            price = "$40",
        ),
        FoodItem(
            id = "3",
            name = "Meat Pizza",
            description = "Spicy burger",
            price = "$40",
        ),
        FoodItem(
            id = "4",
            name = "Meat Pizza",
            description = "Spicy burger",
            price = "$40",
        )
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // First row - Burger items
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FoodItemCard(
                item = foodItems[0],
                onAddClick = { onItemAdd(foodItems[0].id) },
                modifier = Modifier.weight(1f)
            )
            FoodItemCard(
                item = foodItems[1],
                onAddClick = { onItemAdd(foodItems[1].id) },
                modifier = Modifier.weight(1f)
            )
        }

        // Second row - Pizza items
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FoodItemCard(
                item = foodItems[2],
                onAddClick = { onItemAdd(foodItems[2].id) },
                modifier = Modifier.weight(1f)
            )
            FoodItemCard(
                item = foodItems[3],
                onAddClick = { onItemAdd(foodItems[3].id) },
                modifier = Modifier.weight(1f)
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
            modifier = Modifier.padding(24.dp)
        )
    }
}
