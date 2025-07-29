package rekru.zr.utils

import rekru.zr.ui.screen.restaurant.components.FoodCategory
import rekru.zr.ui.screen.restaurant.components.FoodItem

private val burgers = listOf(
    FoodItem(
        category = FoodCategory.Burger,
        name = "Burger Ferguson",
        description = "Spicy Restaurant",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Burger,
        name = "Rockin' Burgers",
        description = "Cafecafachino",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Burger,
        name = "Meat Pizza",
        description = "Spicy burger",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Burger,
        name = "Meat Pizza",
        description = "Spicy burger",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Burger,
        name = "Rockin' Burgers",
        description = "Cafecafachino",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Burger,
        name = "Meat Pizza",
        description = "Spicy burger",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Burger,
        name = "Meat Pizza",
        description = "Spicy burger",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Burger,
        name = "Meat Pizza",
        description = "Spicy burger",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Burger,
        name = "Meat Pizza",
        description = "Spicy burger",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Burger,
        name = "Meat Pizza",
        description = "Spicy burger",
        price = "$40",
    ),
)

private val pizzas = listOf(
    FoodItem(
        category = FoodCategory.Pizza,
        name = "Pizza Ferguson",
        description = "Spicy restaurant",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Pizza,
        name = "Rockin' Burgers",
        description = "Cafecafachino",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Pizza,
        name = "Meat Pizza",
        description = "Spicy burger",
        price = "$40",
    ),
    FoodItem(
        category = FoodCategory.Pizza,
        name = "Meat Pizza",
        description = "Spicy burger",
        price = "$40",
    )
)

fun mapOfFoodItems() = mapOf(
    FoodCategory.Burger to burgers,
    FoodCategory.Pizza to pizzas,
)