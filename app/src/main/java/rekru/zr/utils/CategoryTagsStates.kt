package rekru.zr.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import rekru.zr.ui.screen.restaurant.components.FoodCategory

/**
 * Magic numbers to get the right padding for each category tag, because
 * someone used fixed magic numbers depending on the word instead of just standard padding values
 * Translated from values for IP 13 mini to Pixel 4 by trial and error
 */
fun getExampleStates() = mapOf(
    FoodCategory.Burger to PaddingValues(horizontal = 20.dp, vertical = (11.8).dp),
    FoodCategory.Sandwich to PaddingValues(start = (16.25).dp, end = (18.9).dp, top =12.dp , bottom = 13.dp),
    FoodCategory.Pizza to  PaddingValues(start = (15.74).dp, end = (15).dp, top =12.dp , bottom = 13.dp),
    FoodCategory.Sanwich to PaddingValues(start = (16.25).dp, end = (10.95).dp, top =(11.5).dp , bottom = (13.5).dp),
)