package com.example.jetpack_exp

data class Product(
    val id:Int,
    val name:String,
    val price:Double,
    val imageUrl:String
)

val sampleProducts = listOf(
    Product(1, "Coffee Beans", 120.0, "https://picsum.photos/200"),
    Product(2, "Green Tea", 80.0, "https://picsum.photos/210"),
    Product(3, "Chocolate", 150.0, "https://picsum.photos/220"),
    Product(4, "Cookies", 60.0, "https://picsum.photos/230")
)