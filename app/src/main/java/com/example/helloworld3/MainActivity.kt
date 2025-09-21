package com.example.helloworld3

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: ConstraintLayout
    private lateinit var imageLikes: ImageView
    private lateinit var intLikes: TextView
    private lateinit var imageSent: ImageView
    private lateinit var intSent: TextView
    private lateinit var imageLook: ImageView
    private lateinit var intLook: TextView
    private lateinit var iconAuthor: ImageView
    private lateinit var menuButton: Button

    private var isLiked = false
    private var likeCount = 999999
    private var shareCount = 999
    private var viewCount = 999

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.main)
        imageLikes = findViewById(R.id.imageLikes)
        intLikes = findViewById(R.id.intLikes)
        imageSent = findViewById(R.id.imageSent)
        intSent = findViewById(R.id.intSent)
        imageLook = findViewById(R.id.imageLook)
        intLook = findViewById(R.id.intLook)
        iconAuthor = findViewById(R.id.iconAuthor)
        menuButton = findViewById(R.id.menu)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        updateCounts()

        imageLikes.setOnClickListener {
            isLiked = !isLiked

            if (isLiked) {
                likeCount++
                imageLikes.setImageResource(android.R.drawable.btn_star_big_on)
            } else {
                likeCount--
                imageLikes.setImageResource(android.R.drawable.btn_star_big_off)
            }

            intLikes.text = formatNumber(likeCount)
            println("Обработчик лайков сработал: $likeCount")
        }

        imageSent.setOnClickListener {
            shareCount++
            intSent.text = formatNumber(shareCount)
            println("Обработчик репостов сработал: $shareCount")
        }

        imageLook.setOnClickListener {
            viewCount++
            intLook.text = formatNumber(viewCount)
            println("Обработчик просмотров сработал: $viewCount")
        }

        iconAuthor.setOnClickListener {
            println("Обработчик аватарки сработал")
        }

        menuButton.setOnClickListener {
            println("Обработчик меню сработал")
        }
    }

    private fun updateCounts() {
        intLikes.text = formatNumber(likeCount)
        intSent.text = formatNumber(shareCount)
        intLook.text = formatNumber(viewCount)
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