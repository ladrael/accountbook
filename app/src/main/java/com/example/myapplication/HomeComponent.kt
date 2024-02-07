package com.example.myapplication

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.md_theme_dark_error
import com.example.myapplication.ui.theme.md_theme_dark_primary

@Preview(name="buttonGrid")
@Composable
fun ButtonGrid(){
    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        items(5){

            }
        }

    }


@Composable
fun customButton(){
    Button(
        onClick = { /*TODO*/ },
//        colors = ButtonDefaults.buttonColors(
//            containerColor = MaterialTheme.colorScheme.inverseOnSurface
//        ) 따로 컬러 지정해 줄 때 사용하면 됨
    ) {
        
    }
}

@Preview(
    name="LIGHT"
)
@Preview(
    name="NIGHT",
    uiMode =UI_MODE_NIGHT_YES
)
@Composable
fun previewCustomButton(){
    MyApplicationTheme {            // 이 안에서 실행하면 되는
        customButton()
    }
}