package rekru.zr.ui.screen.restaurant

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import rekru.zr.R
import rekru.zr.ui.screen.restaurant.components.*
import rekru.zr.ui.theme.ZRTheme
import rekru.zr.utils.getExampleStates
import rekru.zr.utils.mapOfFoodItems
import rekru.zr.viewmodel.RestaurantViewmodel

data class Restaurant(
    val foodItems: Map<FoodCategory, List<FoodItem>> = mapOfFoodItems(),
    val restaurantName: String = "Spicy Restaurant",
    val restaurantDescription: String = "Maecenas sed diam eget risus varius blandit sit amet non magna. Integer posuere erat a ante venenatis dapibus posuere velit aliquet.",
)

/**
 * Main Restaurant Detail Screen displaying restaurant information, categories, and food items
 */
@Composable
fun RestaurantDetailScreen(
    restaurant: Restaurant = Restaurant(),
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onMenuClick: () -> Unit = {},
    onFoodItemAdd: (FoodItem) -> Unit = {},
    viewModel: RestaurantViewmodel = hiltViewModel(),
) {
    val selectedCategory by viewModel.selectedCategory.collectAsStateWithLifecycle()
    val carouselCurrentPage by viewModel.carouselCurrentPage.collectAsStateWithLifecycle()
    val isAutoScrollActive by viewModel.isAutoScrollActive.collectAsStateWithLifecycle()
    val amountOfSelectedFood = restaurant.foodItems[selectedCategory]?.count() ?: 0

    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                //bottom padding for navbar
                .padding(bottom = it.calculateBottomPadding())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
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
                    modifier = Modifier.padding(start = 29.dp, end = 29.dp, top = 50.dp)
                )
            }

            Spacer(modifier = Modifier.heightIn(25.dp))

            Column(
                modifier = Modifier.padding(start = 29.dp,end = 24.dp)
            ) {
                RestaurantInfo(
                    rating = 4.7f,
                    isFreeDelivery = true,
                    deliveryTime = "20 min",
                    modifier = Modifier
                        .widthIn(263.dp)
                        .heightIn(20.dp)
                        .offset(y = (-3).dp)
                )

                Spacer(modifier = Modifier.heightIn(13.dp))

                RestaurantDetails(
                    name = restaurant.restaurantName,
                    description = restaurant.restaurantDescription
                )
            }

            Column(
                modifier = Modifier.padding(start= 29.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                Spacer(modifier = Modifier.heightIn(32.dp))

                CategoryTags(
                    selectedCategory = selectedCategory,
                    onCategorySelected = viewModel::selectCategory
                )

                Spacer(modifier = Modifier.heightIn(32.dp))

                SectionTitle(
                    selectedCategory = selectedCategory,
                    amountOfSelectedFood = amountOfSelectedFood
                )
            }

            Spacer(modifier = Modifier.heightIn(16.dp))

            FoodItemGrid(
                selectedCategory = selectedCategory,
                onItemAdd = onFoodItemAdd,
                foodItems = restaurant.foodItems,
                modifier =  Modifier.padding(start = 30.dp,end = 23.dp)
            )
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Composable
fun JpegPreview() {
    ZRTheme {
        Box(Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.obrazek),
                contentDescription = "Image of the figma design",
                contentScale = ContentScale.Fit
            )
            RestaurantDetailScreen(
                viewModel = RestaurantViewmodel(),
                modifier = Modifier
                    .alpha(0.5f)
                    .zIndex(2f)
            )
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Composable
fun RestaurantDetailScreenPreview() {
    ZRTheme {
        RestaurantDetailScreen(viewModel = RestaurantViewmodel())
    }
}
