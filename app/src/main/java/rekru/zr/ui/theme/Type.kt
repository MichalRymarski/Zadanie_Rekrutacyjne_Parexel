package rekru.zr.ui.theme

import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import rekru.zr.R

// Set of Material typography styles to start with
val Sen = FontFamily(
    Font(R.font.sen_bold, weight = FontWeight.Bold),
    Font(R.font.sen_extrabold, weight = FontWeight.ExtraBold),
    Font(R.font.sen_medium, weight = FontWeight.Medium),
    Font(R.font.sen_regular, weight = FontWeight.Normal),
    Font(R.font.sen_semibold, weight = FontWeight.SemiBold),
    )
val Typography = Typography(

    bodyLarge = TextStyle(
        fontFamily = Sen,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Sen,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Sen,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelLarge = TextStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = Sen,
        color = TextSecondary,
        letterSpacing = (-0.333).sp,
    ),
    labelMedium = TextStyle(
        fontFamily = Sen,
        fontWeight = FontWeight.Normal,
        color = TextTertiary,
        fontSize = 13.sp,
    )
)

