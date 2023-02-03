package com.example.compose.lazycolumn.bug

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FiveSecondsText(
    text: String,
    modifier: Modifier
) {
    val scope = rememberCoroutineScope()
    val showText = remember { mutableStateOf(true) }

    if (showText.value) {
        Text(text = text, modifier = modifier)
    }

    LaunchedEffect(Unit) {
        scope.launch {
            delay(5000L)
            showText.value = false
        }
    }
}