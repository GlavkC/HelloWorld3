package com.example.helloworld3

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.helloworld3.databinding.PostItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup

class PostAdapter(
    private val onLikeListener: OnLikeListener,
    private val onShareListener: OnShareListener
) : ListAdapter<Post, PostViewHolder>(PostDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostItemBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding, onLikeListener, onShareListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}