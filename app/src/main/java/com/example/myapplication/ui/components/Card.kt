package com.example.myapplication.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun jujuCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    content: @Composable ColumnScope.() -> Unit
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = modifier,
        content = content,
        shape = shape,
    )
}

@Preview(name="default")
@Preview(name="darkMode", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewJujuCard(){
    MyApplicationTheme {
        jujuCard(modifier = Modifier.size(width = 240.dp, height = 100.dp)) {
            Text(text = "DEMO")
        }
    }
}