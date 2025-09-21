package com.example.helloworld3

import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld3.databinding.PostItemBinding

class PostViewHolder(
    private val binding: PostItemBinding,
    private val onLikeListener: OnLikeListener,
    private val onShareListener: OnShareListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        binding.apply {
            iconAuthor.setImageResource(post.authorAvatar)
            authorText.text = post.authorText
            authorName.text = post.authorName
            postText.text = post.postText

            // Обновляем состояние лайка
            if (post.likedByMe) {
                imageLikes.setImageResource(android.R.drawable.btn_star_big_on)
            } else {
                imageLikes.setImageResource(android.R.drawable.btn_star_big_off)
            }

            intLikes.text = formatNumber(post.likeCount)
            intSent.text = formatNumber(post.shareCount)
            intLook.text = formatNumber(post.viewCount)

            // Обработчики кликов
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