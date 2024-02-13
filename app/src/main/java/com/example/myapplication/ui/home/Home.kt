package com.example.myapplication.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.components.ScaffoldExample
import com.example.myapplication.ui.components.jujuCard
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home (
  modifier: Modifier = Modifier
){
    ScaffoldExample(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                     IconButton(onClick = { /*TODO*/ }) {
                         Icon(
                             imageVector = Icons.Filled.Home,
                             contentDescription = stringResource(id = R.string.home)
                         )
                     }
                },
                title = {
                    Text(
                        text = "검색어",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                actions = {// 앱바 오른쪽 영역
                    IconButton(onClick = {/*doSomething()*/}){
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        }
    ){
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            jujuCard(
                modifier = Modifier.size(width = 180.dp, height = 100.dp)
            ) {
                Box(Modifier.fillMaxWidth()){
                    Text("Clickable",Modifier.align(Alignment.Center))
                }
            }
        }
    }
}

//@Composable
//private fun Home(){
//
//}

@Preview
@Composable
fun PreviewHome(){
    MyApplicationTheme {
        Home(modifier = Modifier)
    }

}
