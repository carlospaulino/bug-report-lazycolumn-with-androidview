package com.example.compose.lazycolumn.bug

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.setPadding
import com.example.compose.lazycolumn.bug.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn {
                        item {
                            Text(
                                text = "Header",
                                color = Color.White,
                                modifier = Modifier
                                    .background(Color.Blue)
                                    .fillMaxWidth()
                                    .padding(24.dp)
                            )
                        }
                        // This Composable won't disappear after five seconds
                        item {
                            AndroidView(
                                modifier = Modifier
                                    .background(Color.Gray)
                                    .fillMaxWidth(),
                                factory = { context ->
                                    val contentPadding = resources.getDimension(R.dimen.content_padding).toInt()
                                    FiveSecondsTextView(context)
                                        .apply {
                                            text = "View Content"
                                            setPadding(contentPadding)
                                        }
                                })
                        }
                        // This Composable will disappear after five seconds
                        item {
                            FiveSecondsText(
                                text = "Composable Content",
                                Modifier
                                    .background(Color.DarkGray)
                                    .fillMaxWidth()
                                    .padding(24.dp)
                            )
                        }

                        item {
                            Text(
                                text = "Footer",
                                color = Color.White,
                                modifier = Modifier
                                    .background(Color.Red)
                                    .fillMaxWidth()
                                    .padding(24.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
