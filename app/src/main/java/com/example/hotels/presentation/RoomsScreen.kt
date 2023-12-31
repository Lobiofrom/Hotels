package com.example.hotels.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.domain.models.Room
import com.example.hotels.R
import com.example.hotels.viewModels.RoomsViewModel

@Composable
fun RoomsScreen(
    hotelName: String,
    navController: NavController,
    viewModel: RoomsViewModel
) {
    var rooms by remember {
        mutableStateOf<List<Room>>(emptyList())
    }

    LaunchedEffect(Unit) {
        viewModel.rooms.collect {
            rooms = it
        }
    }
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(top = 6.dp),
        shadowElevation = 5.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_4),
                    contentDescription = null,
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                        .align(Alignment.CenterStart)
                        .padding(start = 10.dp)
                        .clickable { navController.navigate("hotel") }
                )
                Text(
                    text = hotelName,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 46.dp)
                )
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 55.dp)
    ) {
        items(rooms) {
            ItemRoom(room = it, onButtonClick = { navController.navigate("booking") })
        }
    }
}