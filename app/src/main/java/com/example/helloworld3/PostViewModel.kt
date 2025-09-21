package com.example.helloworld3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    init {
        loadPosts()
    }

    private fun loadPosts() {
        val initialPosts = listOf(
            Post(
                id = 1,
                authorName = "Тима",
                authorText = "Мой первый пост",
                postText = "Это мой первый пост в этом приложении!",
                published = "5 минут назад",
                likeCount = 15,
                shareCount = 3,
                viewCount = 100
            ),
            Post(
                id = 2,
                authorName = "Дима",
                authorText = "Поддержка стен текста",
                postText = "увы, но из проекта были удалены все стены текста.",
                published = "2 часа назад",
                likedByMe = true,
                likeCount = 42,
                shareCount = 7,
                viewCount = 256
            ),
            Post(
                id = 3,
                authorName = "Саша",
                authorText = "Новости",
                postText = "Внимание, в Москве пройдет концерт Тимофея Тимофекова Тимофеевича в 9.59!",
                published = "1 день назад",
                likeCount = 89,
                shareCount = 12,
                viewCount = 543
            ),
            Post(
                id = 4,
                authorName = "Wolf",
                authorText = "Правила волка",
                postText = "первое, не надо быть серым волком.",
                published = "3 дня назад",
                likeCount = 127,
                shareCount = 25,
                viewCount = 892
            ),
            Post(
                id = 5,
                authorName = "Clone0",
                authorText = "О нет это набег ботов",
                postText = "Злые боты захватили посты как же нам быть!!!",
                published = "4 дня назад",
                likeCount = 999,
                shareCount = 666,
                viewCount = 333
            ),
            Post(
                id = 6,
                authorName = "Clone1",
                authorText = "О нет это набег ботов",
                postText = "Злые боты захватили посты как же нам быть!!!",
                published = "4 дня назад",
                likeCount = 999,
                shareCount = 666,
                viewCount = 333
            ),
            Post(
                id = 7,
                authorName = "Clone2",
                authorText = "О нет это набег ботов",
                postText = "Злые боты захватили посты как же нам быть!!!",
                published = "4 дня назад",
                likeCount = 999,
                shareCount = 666,
                viewCount = 333
            ),
            Post(
                id = 8,
                authorName = "Clone3",
                authorText = "О нет это набег ботов",
                postText = "Злые боты захватили посты как же нам быть!!!",
                published = "4 дня назад",
                likeCount = 999,
                shareCount = 666,
                viewCount = 333
            ),
            Post(
                id = 9,
                authorName = "Clone4",
                authorText = "О нет это набег ботов",
                postText = "Злые боты захватили посты как же нам быть!!!",
                published = "4 дня назад",
                likeCount = 999,
                shareCount = 666,
                viewCount = 333
            ),
            Post(
                id = 10,
                authorName = "Clone5",
                authorText = "О нет это набег ботов",
                postText = "Злые боты захватили посты как же нам быть!!!",
                published = "4 дня назад",
                likeCount = 999,
                shareCount = 666,
                viewCount = 333
            ),
            Post(
                id = 11,
                authorName = "Clone6",
                authorText = "О нет это набег ботов",
                postText = "Злые боты захватили посты как же нам быть!!!",
                published = "4 дня назад",
                likeCount = 999,
                shareCount = 666,
                viewCount = 333
            ),
            Post(
                id = 12,
                authorName = "Clone7",
                authorText = "О нет это набег ботов",
                postText = "Злые боты захватили посты как же нам быть!!!",
                published = "4 дня назад",
                likeCount = 999,
                shareCount = 666,
                viewCount = 333
            ),
            Post(
                id = 13,
                authorName = "Clone8",
                authorText = "О нет это набег ботов",
                postText = "Злые боты захватили посты как же нам быть!!!",
                published = "4 дня назад",
                likeCount = 999,
                shareCount = 666,
                viewCount = 333
            ),
            Post(
                id = 14,
                authorName = "Clone9",
                authorText = "О нет это набег ботов",
                postText = "Злые боты захватили посты как же нам быть!!!",
                published = "4 дня назад",
                likeCount = 999,
                shareCount = 666,
                viewCount = 333
            ),
            Post(
                id = 15,
                authorName = "Clone10",
                authorText = "О нет это набег ботов",
                postText = "Злые боты захватили посты как же нам быть!!!",
                published = "4 дня назад",
                likeCount = 999,
                shareCount = 666,
                viewCount = 333
            )
        )
        _posts.value = initialPosts
    }

    fun likePost(postId: Long) {
        val currentPosts = _posts.value ?: return
        val updatedPosts = currentPosts.map { post ->
            if (post.id == postId) {
                if (post.likedByMe) {
                    post.copy(
                        likedByMe = false,
                        likeCount = post.likeCount - 1
                    )
                } else {
                    post.copy(
                        likedByMe = true,
                        likeCount = post.likeCount + 1
                    )
                }
            } else {
                post
            }
        }
        _posts.value = updatedPosts
    }

    fun sharePost(postId: Long) {
        val currentPosts = _posts.value ?: return
        val updatedPosts = currentPosts.map { post ->
            if (post.id == postId) {
                post.copy(shareCount = post.shareCount + 1)
            } else {
                post
            }
        }
        _posts.value = updatedPosts
    }

    fun viewPost(postId: Long) {
        val currentPosts = _posts.value ?: return
        val updatedPosts = currentPosts.map { post ->
            if (post.id == postId) {
                post.copy(viewCount = post.viewCount + 1)
            } else {
                post
            }
        }
        _posts.value = updatedPosts
    }
}