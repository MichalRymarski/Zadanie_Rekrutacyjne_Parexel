package rekru.zr.ui.screen.restaurant.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import rekru.zr.R
import rekru.zr.ui.theme.CardBackground
import rekru.zr.ui.theme.RestaurantOrange
import rekru.zr.ui.theme.Sen
import rekru.zr.ui.theme.ShadowGray
import rekru.zr.ui.theme.TextPrimary
import rekru.zr.ui.theme.TextSecondary
import rekru.zr.ui.theme.TextTertiary
import rekru.zr.ui.theme.ZRTheme
import rekru.zr.utils.dropShadow

/**
 * Food item card component
 */
@Composable
fun FoodItemCard(
    item: FoodItem,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .width(153.dp)
            .height(174.dp)
            .dropShadow(
                color = ShadowGray,
                shape = RoundedCornerShape(25.dp),
                blur = 30.dp,
                offsetX = 12.dp,
                offsetY = 12.dp
            ),
        shape = RoundedCornerShape(25.dp),
        border = BorderStroke(2.dp, Color.White),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.menu_item),
                contentDescription = item.name,
                modifier = Modifier
                    .width(114.dp)
                    .height(75.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .padding(start = 11.dp, end = 12.dp,bottom = 5.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy((-3).dp)
            ) {
                Text(
                    text = item.name,
                    maxLines = 1,
                    fontFamily = Sen,
                    letterSpacing = (-0.333).sp,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = item.description,
                    maxLines = 1,
                    fontFamily = Sen,
                    letterSpacing = 0.sp,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = TextTertiary
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.price,
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 16.sp,
                        color = TextPrimary,
                    )

                    AddButton(
                        onClick = onAddClick
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
fun AddButton(
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = modifier.sizeIn(33.dp,33.dp).offset(x= 12.dp), // No idea why there's extra space at the end of the row
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors().copy(containerColor = RestaurantOrange),
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.plus),
            contentDescription = "Add menu item to cart button",
            tint = Color.White,
            modifier = Modifier
                .width(11.dp)
                .height(10.dp)
        )
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
fun FoodItemCardPreview() {
    ZRTheme {
        FoodItemCard(
            item = FoodItem(
                category = FoodCategory.Burger,
                name = "Burger Ferguson",
                description = "Spicy Restaurant",
                price = "$40",
            ),
            onAddClick = {}
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Composable
fun PreviewFinalCards() {
    ZRTheme {
        Image(
            painter = painterResource(R.drawable.image_cards),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

