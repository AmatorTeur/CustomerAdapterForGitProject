package com.example.myapplication

import com.squareup.moshi.Json

data class Repo(
    @Json(name = "name")
    val name: String
)