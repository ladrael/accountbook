package com.example.myapplication.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.components.HomeCard
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home (
  modifier: Modifier = Modifier
){
    Scaffold(
        //TODO 검색바를 topappbar 위치에 두기
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
    ){ paddingValue ->
        Surface(modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValue)) {
            //TODO grid 만들어서 column 안에 배치되어야하는 구조

            Column(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                HomeCard(
                    modifier = Modifier.size(width = 140.dp, height = 100.dp),
                    text = "000"
                )
            }
            LazyVerticalGrid(
                //columns = GridCells.Adaptive(minSize = 30.dp) 지정된 사이즈만큼 그리드
                columns = GridCells.Fixed(2)
            ){
                item(
                    span = {
                        GridItemSpan(maxLineSpan)
                }){

                }
            }
        }
    }
}

//@Preview
@Composable
fun PreviewHome(){
    MyApplicationTheme {
        Home(modifier = Modifier)
    }

}
@Preview()
@Composable
fun HomeContents(){
    LazyColumn {
        item {
            Text(
                text = "First item",
                color = Color.White
            )
        }
        items(5) { index ->
            Text(text = "items $index", color = Color.White)
        }
    }
}