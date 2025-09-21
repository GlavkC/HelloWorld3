package com.example.helloworld3

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostViewHolder(
    itemView: View,
    private val onLikeListener: OnLikeListener,
    private val onShareListener: OnShareListener
) : RecyclerView.ViewHolder(itemView) {

    private val iconAuthor: ImageView = itemView.findViewById(R.id.iconAuthor)
    private val authorText: TextView = itemView.findViewById(R.id.authorText)
    private val authorName: TextView = itemView.findViewById(R.id.authorName)
    private val postText: TextView = itemView.findViewById(R.id.postText)
    private val imageLikes: ImageView = itemView.findViewById(R.id.imageLikes)
    private val intLikes: TextView = itemView.findViewById(R.id.intLikes)
    private val imageSent: ImageView = itemView.findViewById(R.id.imageSent)
    private val intSent: TextView = itemView.findViewById(R.id.intSent)
    private val intLook: TextView = itemView.findViewById(R.id.intLook)

    fun bind(post: Post) {
        iconAuthor.setImageResource(post.authorAvatar)
        authorText.text = post.authorText
        authorName.text = post.authorName
        postText.text = post.postText

        if (post.likedByMe) {
            imageLikes.setImageResource(android.R.drawable.btn_star_big_on)
        } else {
            imageLikes.setImageResource(android.R.drawable.btn_star_big_off)
        }

        intLikes.text = formatNumber(post.likeCount)
        intSent.text = formatNumber(post.shareCount)
        intLook.text = formatNumber(post.viewCount)

        imageLikes.setOnClickListener {
            onLikeListener.onLike(post.id)
        }

        imageSent.setOnClickListener {
            onShareListener.onShare(post.id)
        }

        iconAuthor.setOnClickListener {
            println("Обработчик аватарки сработал для поста ${post.id}")
        }
    }

    private fun formatNumber(number: Int): String {
        return when {
            number < 1000 -> number.toString()
            number < 10000 -> {
                val thousands = number / 1000
                val hundreds = (number % 1000) / 100
                if (hundreds > 0) "$thousands.${hundreds}K" else "${thousands}K"
            }
            number < 1000000 -> "${number / 1000}K"
            else -> {
                val millions = number / 1000000
                val hundredThousands = (number % 1000000) / 100000
                if (hundredThousands > 0) "$millions.${hundredThousands}M" else "${millions}M"
            }
        }
    }
}