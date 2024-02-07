package com.example.myapplication.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun ExtendedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onTertiary
            /* Other colors use values from MaterialTheme */
        ),
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
        onClick = onClick,
        modifier = modifier,
        content = content

    )
}
/**
 * 플로팅 버튼
 * */
@Composable
fun LargeFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shapes: Shape = FloatingActionButtonDefaults.largeShape,
    containerColor: Color = FloatingActionButtonDefaults.containerColor,
    contentColor: Color = contentColorFor(containerColor),
    content: @Composable () -> Unit
    ){
}


@Preview(
    name="LIGHT"
)
@Preview(
    name="NIGHT",
    uiMode =UI_MODE_NIGHT_YES,
)
@Composable
fun PreviewCustomButton(){
    MyApplicationTheme {            // 이 안에서 실행하면 되는
        ExtendedButton(
            onClick = {/* TODO */},
        ){
            Text("Sample")
        }
    }
}
@Preview(   )
@Composable
fun PreviewFloatButton(){

}