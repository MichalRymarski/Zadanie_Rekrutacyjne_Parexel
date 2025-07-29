package rekru.zr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import rekru.zr.ui.screen.restaurant.RestaurantDetailScreen
import rekru.zr.ui.theme.ZRTheme

/**
 * Main Activity for the Restaurant Application
 * Implements edge-to-edge design with transparent system bars
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ensure status bar is transparent and content goes behind it
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ZRTheme {
                RestaurantDetailScreen(
                    onBackClick = { finish() },
                    onMenuClick = {
                        println("Menu clicked")
                    },
                    onFoodItemAdd = { itemId ->
                        println("Added item $itemId to cart")
                    }
                )
            }
        }
    }
}
