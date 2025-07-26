package rekru.zr.ui.screen.recruitment.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import rekru.zr.R
import rekru.zr.ui.theme.PrimaryOrange
import rekru.zr.viewmodel.FakeRecruitmentViewmodel
import rekru.zr.viewmodel.RecruitmentViewmodel



@Composable
fun RecruitmentScreen(
    viewModel: RecruitmentViewmodel = hiltViewModel(),
) {
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(R.drawable.obrazek),
        contentDescription = null
    )
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Preview(name = "PIXEL_7", device = Devices.PIXEL_7)
@Preview(name = "NEXUS_5", device = Devices.NEXUS_5)
@Composable
fun RecruitmentScreenPreview(){
    val fakeRecruitmentViewmodel = FakeRecruitmentViewmodel()
    RecruitmentScreen(
        viewModel = fakeRecruitmentViewmodel
    )
}

@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Preview(name = "PIXEL_7", device = Devices.PIXEL_7)
@Preview(name = "NEXUS_5", device = Devices.NEXUS_5)
@Composable
fun Star(){
    Icon(
        painter = painterResource(R.drawable.star),
        tint = PrimaryOrange,
        contentDescription = null
    )
}

@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Preview(name = "PIXEL_7", device = Devices.PIXEL_7)
@Preview(name = "NEXUS_5", device = Devices.NEXUS_5)
@Composable
fun Truck(){
    Icon(
        painter = painterResource(R.drawable.delivery),
        tint = PrimaryOrange,
        contentDescription = null
    )
}

@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Preview(name = "PIXEL_7", device = Devices.PIXEL_7)
@Preview(name = "NEXUS_5", device = Devices.NEXUS_5)
@Composable
fun Clock(){
    Icon(
        painter = painterResource(R.drawable.delivery_time),
        tint = PrimaryOrange,
        contentDescription = null
    )
}

@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Preview(name = "PIXEL_7", device = Devices.PIXEL_7)
@Preview(name = "NEXUS_5", device = Devices.NEXUS_5)
@Composable
fun CustomScreen() {
    /*
    Scaffold :
    1. implement a top bar with 2 buttons on each end
    2. Make it transparent.
    3. Make the buttons float ( Z level)
    4. Make content padding ignore topbar padding.

    Column ( IT SHOULD BE SCROLLABLE):
        1. Carousel :
            - Make an image composable with corner radius to make it fit
            - Design the indicator and its inactive state
            - Create the row of indicators
            - take some pictures and put those in a list
        2. Restaurant Description:
            - Create a Row of icons with labels
            - Create a medium title label with the restaurant's name
            - Create a description of the restaurant
        3. Food Categories :
            - Design a button thats outlined while inactive and non-outlined while active
            - Put those in a Row,
            - Share a selection state between them
        4. Food Propositions (from the current restaurant):
            - Create a card composable with shadow in the top left ( I have to guess  )
            - use pngs inside them
            - Put labels and description on them,
            - create a button with a primary color
            - put a lot of burgers inside this

    * */
    Scaffold {
        Column {

        }
    }
}


