package com.melis.postapp.data.remote

import com.google.gson.annotations.SerializedName

data class PostDto(
    val id: Int,
    @SerializedName("userId")
    val userId: Int,
    val title: String,
    val body: String
)