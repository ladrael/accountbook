package com.example.myapplication.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun jujuCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    colors: CardColors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ),
    elevation: CardElevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,
        pressedElevation = 2.dp,
        focusedElevation = 4.dp
    ),
    border: BorderStroke? = null,
    content: @Composable ColumnScope.() -> Unit,
){
    Card(
        modifier = modifier,
        colors = colors,
        elevation = elevation,
        border = border,
        content = content,
        shape = shape,
    )
}

@Preview(name="default", showBackground = true)
@Preview(name="darkMode", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewJujuCard(){
    MyApplicationTheme {
        jujuCard(
            modifier = Modifier.size(width = 180.dp, height = 100.dp)
        ){
            Box(Modifier.fillMaxWidth()){
              Text("Clickable",Modifier.align(Alignment.Center))
            }

        }
    }
}