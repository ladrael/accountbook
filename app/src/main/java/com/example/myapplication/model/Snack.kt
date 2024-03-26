package com.example.myapplication.model

import androidx.compose.runtime.Immutable

@Immutable  //불변속성 어노테이션
data class Snack(               //data class : 여러가지 메서드 내포하고있음
    val tag: String = ""          //상수값 사용할때 var이 아닌 val
)

/**
 *  Static data
 */

val snacks = listOf(
    Snack(
        tag = "contents1"
    ),
    Snack(
        tag = "contents2"
    )
)