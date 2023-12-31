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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hotels.R

@Composable
fun FinalScreen(
    navController: NavController
) {

    val number by remember {
        mutableIntStateOf((100000..999999).random())
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            color = Color.White,
            shape = RoundedCornerShape(20.dp),
            shadowElevation = 5.dp,
            modifier = Modifier.padding(top = 6.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_4), contentDescription = null,
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                        .align(Alignment.CenterStart)
                        .padding(start = 10.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
                Text(
                    text = "Заказ оплачен",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(start = 46.dp)
                        .align(Alignment.CenterStart)
                )
            }
        }
        Surface(
            color = Color.White,
            shape = RoundedCornerShape(20.dp),
            shadowElevation = 5.dp,
            modifier = Modifier
                .padding(top = 70.dp, bottom = 70.dp)
                .align(Alignment.Center)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.wow),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 300.dp)
                )
                Text(
                    text = "Ваш заказ принят в работу",
                    style = TextStyle(
                        fontSize = 22.sp,
                        lineHeight = 26.4.sp,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp)
                )
                Text(
                    text = "Подтверждение заказа №$number может занять некоторое время (от 1 часа до суток). Как только мы получим ответ от туроператора, вам на почту придет уведомление.",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 19.2.sp,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp)
                )
            }
        }
        Surface(
            color = Color.White,
            shape = RoundedCornerShape(20.dp),
            shadowElevation = 5.dp,
            modifier = Modifier
                .padding(top = 6.dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        navController.navigate("hotel")
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(343.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(android.graphics.Color.parseColor("#0D72FF"))
                    ),
                ) {
                    Text(
                        text = "Супер!"
                    )
                }
            }
        }
    }
}