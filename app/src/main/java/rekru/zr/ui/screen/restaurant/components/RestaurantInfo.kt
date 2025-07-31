package rekru.zr.ui.screen.restaurant.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rekru.zr.R
import rekru.zr.ui.theme.PrimaryOrange
import rekru.zr.ui.theme.RestaurantOrangeSecondary
import rekru.zr.ui.theme.Sen
import rekru.zr.ui.theme.TextPrimary
import rekru.zr.ui.theme.ZRTheme

/**
 * Restaurant information component displaying rating, delivery status, and time
 */
@Composable
fun RestaurantInfo(
    rating: Float,
    isFreeDelivery: Boolean,
    deliveryTime: String,
    modifier: Modifier = Modifier
        .width(260.dp)
        .heightIn(20.dp),
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(36.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Rating with star icon
        Rating(rating.toString())

        // Free Delivery with truck icon
        DeliveryCost("Free")

        // Delivery Time with clock icon
        DeliveryTime(deliveryTime)
    }
}


@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
private fun RestaurantInfoPreview() {
    ZRTheme {
        Surface(
            Modifier
                .widthIn(263.dp)
                .heightIn(20.dp)) {
            RestaurantInfo(
                rating = 4.7f,
                isFreeDelivery = true,
                deliveryTime = "20 min",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun Rating(rating: String = "4.7") {
    Row(
        modifier = Modifier.heightIn(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        StarIcon()
        Text(
            text = rating,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary,
            fontFamily = Sen,
        )
    }
}


@Composable
private fun DeliveryTime(deliveryTime: String = "20 min") {
    Row(
        modifier = Modifier.heightIn(20.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ClockIcon()
        Text(
            text = deliveryTime,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = TextPrimary,
            fontFamily = Sen,
        )
    }
}


@Preview(showBackground = true, device = Devices.NEXUS_5, name = "NEXUS_5")
@Preview(showBackground = true, device = Devices.PIXEL_4, name = "PIXEL_4")
@Preview(showBackground = true, device = Devices.PIXEL_7, name = "PIXEL_7")
@Composable
private fun DeliveryCost(cost: String = "Free") {
    Row(
        modifier = Modifier.heightIn(20.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        DeliveryTruckIcon()
        Text(
            text = cost,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = TextPrimary,
            fontFamily = Sen,
        )
    }
}

@Composable
private fun StarIcon() {
    Icon(
        painter = painterResource(R.drawable.star),
        tint = RestaurantOrangeSecondary,
        modifier = Modifier.sizeIn(20.dp,20.dp),
        contentDescription = "Rating icon"
    )
}

@Composable
private fun DeliveryTruckIcon() {
    Icon(
        painter = painterResource(R.drawable.delivery),
        tint = RestaurantOrangeSecondary,
        modifier = Modifier.sizeIn(20.dp,20.dp),
        contentDescription = "Rating icon"
    )
}

@Composable
private fun ClockIcon() {
    Icon(
        painter = painterResource(R.drawable.clock),
        tint = RestaurantOrangeSecondary,
        modifier = Modifier.sizeIn(20.dp,20.dp),
        contentDescription = "Rating icon"
    )
}



