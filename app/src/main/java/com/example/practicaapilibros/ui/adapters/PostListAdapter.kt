package com.example.practicaapilibros.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaapilibros.databinding.PostListItemBinding
import com.example.practicaapilibros.models.Post
import com.example.practicaapilibros.models.PostList

class PostListAdapter (
    var items: PostList
) : RecyclerView.Adapter<com.example.practicaapilibros.ui.adapters.PostListAdapter.ViewHolder>() {
    private var onPostClickListener: OnPostClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostListItemBinding.inflate(
            inflater,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    public fun setOnPostClickListener(listener: OnPostClick) {
        this.onPostClickListener = listener
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, onPostClickListener)
    }

    fun setData(newData: PostList) {
        this.items = newData
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: PostListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post, listener: OnPostClick?) {
            binding.lblPostTitle.text = item.nombre
            binding.root.setOnClickListener {
                listener?.onPostClick(item)
            }
        }
    }

    interface OnPostClick {
        fun onPostClick(post: Post)
    }
}