package com.example.mealzapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.AsyncImage
import com.example.model.response.MealResponse
import kotlin.math.max
import kotlin.math.min

@Composable
fun MealDetailsScreen(meal: MealResponse?){
//    var profilePictureState by remember { mutableStateOf(MealProfilePictureState.Normal) }
//    val transition = updateTransition(targetState = profilePictureState, label = "")
//    val imageSizeDp by transition.animateDp(targetValueByState = { it.size }, label = "")
//    val color by transition.animateColor(targetValueByState = { it.color }, label = "")
//    val widthSize by transition.animateDp(targetValueByState = { it.borderWidth }, label = "")
    val scrollState = rememberScrollState()
    val offset = min(1f,1-(scrollState.value/600f))
    val size by animateDpAsState(targetValue = max(100.dp, 200.dp * offset))
    Surface {
        Column() {
            Surface(elevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 2.dp,
                            color = Color.Green
                        )
                    ) {
                        AsyncImage(model =meal?.imageUrl, contentDescription ="meal image",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(size)
                                .padding(8.dp)
                        )
                    }
                    Text(text =meal?.name?:"default name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically))

                }
            }

            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text column", modifier = Modifier.padding(32.dp))
            }
//            Button(modifier = Modifier.padding(16.dp)
//                ,onClick = {
//                    profilePictureState = if(profilePictureState == MealProfilePictureState.Normal)
//                        MealProfilePictureState.Expanded
//                    else
//                        MealProfilePictureState.Normal
//                }) {
//                Text(text = "Change State of meal profile picture")
//            }
        }
    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp){
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Green, 200.dp, 24.dp)
}