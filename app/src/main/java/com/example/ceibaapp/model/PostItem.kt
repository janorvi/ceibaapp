package com.example.ceibaapp.model

import android.widget.TextView
import com.example.ceibaapp.R
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class PostItem(
    val post: Post
): Item<GroupieViewHolder>() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val textViewPostTitle: TextView = viewHolder.itemView.findViewById(R.id.post_title_text_view)
        val textViewPostContent: TextView = viewHolder.itemView.findViewById(R.id.post_content_text_view)
        textViewPostTitle.text = post.title
        textViewPostContent.text = post.body
    }

    override fun getLayout() = R.layout.post_item
}