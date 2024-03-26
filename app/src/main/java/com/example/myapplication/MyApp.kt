package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.components.Conversation
import com.example.myapplication.ui.theme.MyApplicationTheme

@Preview
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MyApp(){
    MyApplicationTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Simple Scaffold Screen") },
                    navigationIcon = {
                        IconButton(
                            onClick = { /* "Open nav drawer" */ }
                        ) {
                            Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                        }
                    }
                )
            },
            bottomBar =  {
                var selectedItem by remember { mutableIntStateOf(0) }   // 1.5.0 added
                val items = listOf("Songs", "Artists", "Playlists")

                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                            label = { Text(item) },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index }
                        )
                    }
                }
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = { /* fab click handler */ }
                ) {
                    Text("Inc")
                }
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier.padding(innerPadding)
                ) {
                    Conversation(messages = SampleData.conversationSample);
                }

            }
        )
    }
}