package com.example.helloworld3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.helloworld3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var isLiked = false
    private var likeCount = 999999
    private var shareCount = 999
    private var viewCount = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        updateCounts(binding)

        binding.main.setOnClickListener {
            println("Обработчик binding.main сработал")
        }

        binding.imageLikes.setOnClickListener {
            isLiked = !isLiked

            if (isLiked) {
                likeCount++
                binding.imageLikes.setImageResource(android.R.drawable.btn_star_big_on)
            } else {
                likeCount--
                binding.imageLikes.setImageResource(android.R.drawable.btn_star_big_off)
            }

            binding.intLikes.text = formatNumber(likeCount)
            println("Обработчик лайков сработал: $likeCount")
        }

        binding.imageSent.setOnClickListener {
            shareCount++
            binding.intSent.text = formatNumber(shareCount)
            println("Обработчик репостов сработал: $shareCount")
        }

        binding.imageLook.setOnClickListener {
            viewCount++
            binding.intLook.text = formatNumber(viewCount)
            println("Обработчик просмотров сработал: $viewCount")
        }

        binding.iconAuthor.setOnClickListener {
            println("Обработчик аватарки сработал")
        }

        binding.menu.setOnClickListener {
            println("Обработчик меню сработал")
        }
    }

    private fun updateCounts(binding: ActivityMainBinding) {
        binding.intLikes.text = formatNumber(likeCount)
        binding.intSent.text = formatNumber(shareCount)
        binding.intLook.text = formatNumber(viewCount)
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