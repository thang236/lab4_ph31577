package com.example.lab4_ph31577

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Home(navControl: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(text = "Hãy chọn bài tập cần đến", fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navControl.navigate("bai1")
        },
            modifier = Modifier.padding(16.dp),
            content = {
                Text("Bai 1")
            },
        )

        Button(onClick = {
            navControl.navigate("bai2")
        },
            modifier = Modifier.padding(16.dp),
            content = {
                Text("Bai 2")
            },
        )

        Button(onClick = {
            navControl.navigate("bai3")
        },
            modifier = Modifier.padding(16.dp),
            content = {
                Text("Bai 3")
            },
        )

    }
}