package com.example.myapplication.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R


enum class HomeSections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route : String
){
    // String properties
    FEED(R.string.tab1, Icons.Outlined.Home, "home/feed"),
    SEARCH(R.string.tab2, Icons.Outlined.Search, "home/search"),
    CART(R.string.tab3, Icons.Outlined.ShoppingCart, "home/cart"),
    PROFILE(R.string.tab4, Icons.Outlined.AccountCircle, "home/profile")
}
@Composable
fun WhatIsThis(
    modifier : Modifier = Modifier,
    navController : NavHostController = rememberNavController(),
    startDestination : String = "profile"
){
    //navigate(R.id)에 명시된 대로 이동을 하는데... 이게 페이지 개념보다는 컴포넌트같은 개념같은
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ){
        composable("profile") { Profile(onNavigateToFriendsList = { navController.navigate("friendslist")}) }
        composable("friendslist") { FriendsList(onNavigateToProfile = {navController.navigate("profile")}) }
        // Add more destinations similarly.
        //anim은 어떻게 쓰는거람 ?????
    }
}
// Define the Profile composable.

@Composable
fun Profile(onNavigateToFriendsList: () -> Unit) {
    Text("Profile")
    Button(onClick = { onNavigateToFriendsList() }) {
        Text("Go to Friends List")
    }
}
@Preview
@Composable
fun PreviewProfile(){
    Profile {

    }
}


// Define the FriendsList composable.
@Composable
fun FriendsList(onNavigateToProfile: () -> Unit) {
    Text("Friends List")
    Button(onClick = { onNavigateToProfile() }) {
        Text("Go to Profile")
    }
}



@Preview
@Composable
fun NavigationControl(
    modifier : Modifier = Modifier,

){
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
}

@Preview(name = "remember 샘플")
@Composable
fun SampleNames() {
    var name by remember { mutableStateOf("user") }
    val names = remember { mutableStateListOf<String>() }

    Column {
        Row {
            BasicTextField(
                value = name,
                onValueChange = { name = it }
            )
            Button(onClick = { names.add(name) }) {
                Text("Add")
            }
        }
        Text("Added names:")
        Column {
            for (addedName in names) {
                Text(addedName)
            }
        }
    }
}


