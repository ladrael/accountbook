package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()  // 시스템바 디스플레이
        super.onCreate(savedInstanceState)
        //setContent { previewConversation()}
        setContent { MyApp()}
        // setContent { WhatIsThis()} // [TEST] Navigator



    }
}





