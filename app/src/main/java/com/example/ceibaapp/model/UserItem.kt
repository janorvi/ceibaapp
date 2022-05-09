package com.example.ceibaapp.model

import android.widget.TextView
import com.example.ceibaapp.R
import com.xwray.groupie.Item
import com.xwray.groupie.GroupieViewHolder

class UserItem(
    val user: User
): Item<GroupieViewHolder>() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val textViewName: TextView = viewHolder.itemView.findViewById(R.id.name_text_view)
        val textViewPhone: TextView = viewHolder.itemView.findViewById(R.id.phone_text_view)
        val textViewEmail: TextView = viewHolder.itemView.findViewById(R.id.email_text_view)
        textViewName.text = user.name
        textViewPhone.text = user.phone
        textViewEmail.text = user.email
    }

    override fun getLayout() = R.layout.user_item
}