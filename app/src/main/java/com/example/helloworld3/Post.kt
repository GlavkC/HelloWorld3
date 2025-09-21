package com.example.helloworld3

data class Post(
    val id: Long,
    val authorName: String,
    val authorText: String,
    val postText: String,
    val published: String,
    val likedByMe: Boolean = false,
    val likeCount: Int = 0,
    val shareCount: Int = 0,
    val viewCount: Int = 0,
    val authorAvatar: Int = R.drawable.icon_author_foreground
)