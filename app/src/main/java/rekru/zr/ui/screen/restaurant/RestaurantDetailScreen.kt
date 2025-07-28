package rekru.zr.ui.screen.restaurant

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import rekru.zr.R
import rekru.zr.ui.screen.restaurant.components.*
import rekru.zr.ui.theme.ZRTheme
import rekru.zr.viewmodel.RestaurantViewmodel

/**
 * Main Restaurant Detail Screen displaying restaurant information, categories, and food items
 */
@Composable
fun RestaurantDetailScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onMenuClick: () -> Unit = {},
    onFoodItemAdd: (String) -> Unit = {},
    viewModel: RestaurantViewmodel = hiltViewModel(),
) {
    val selectedCategory by viewModel.selectedCategory.collectAsStateWithLifecycle()
    val carouselCurrentPage by viewModel.carouselCurrentPage.collectAsStateWithLifecycle()
    val isAutoScrollActive by viewModel.isAutoScrollActive.collectAsStateWithLifecycle()

    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box {
                RestaurantImageCarousel(
                    currentPage = carouselCurrentPage,
                    onPageChanged = viewModel::onCarouselPageChanged,
                    setAutoscroll = viewModel::setAutoScrollActive,
                    modifier = Modifier.fillMaxWidth()
                )

                TopComponent(
                    onBackClick = onBackClick,
                    onMenuClick = onMenuClick,
                    modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 50.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                RestaurantInfo(
                    rating = 4.7f,
                    isFreeDelivery = true,
                    deliveryTime = "20 min",
                )

                Spacer(modifier = Modifier.height(16.dp))

                RestaurantDetails(
                    name = "Spicy restaurant",
                    description = "Maecenas sed diam eget risus varius blandit sit amet non magna. Integer posuere erat a ante venenatis dapibus posuere velit aliquet."
                )

                Spacer(modifier = Modifier.height(32.dp))

                CategoryTags(
                    categories = listOf("Burger", "Sandwich", "Pizza", "Sanwich"),
                    selectedCategory = selectedCategory,
                    onCategorySelected = viewModel::selectCategory
                )

                Spacer(modifier = Modifier.height(32.dp))

                SectionTitle(
                    title = "Burger (10)"
                )

                Spacer(modifier = Modifier.height(16.dp))

                FoodItemGrid(
                    onItemAdd = onFoodItemAdd
                )

                Spacer(modifier = Modifier.height(32.dp))

                FoodItemGrid(
                    onItemAdd = onFoodItemAdd
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Composable
fun FinalPreview() {
    ZRTheme {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.obrazek),
            contentDescription = "Image of the figma design",
            contentScale = ContentScale.FillBounds
        )
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
fun RestaurantDetailScreenPreview() {
    ZRTheme {
        RestaurantDetailScreen(viewModel = RestaurantViewmodel())
    }
}
