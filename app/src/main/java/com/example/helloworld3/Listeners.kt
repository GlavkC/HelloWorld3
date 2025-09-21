package com.example.helloworld3

fun interface OnLikeListener {
    fun onLike(postId: Long)
}

fun interface OnShareListener {
    fun onShare(postId: Long)
}