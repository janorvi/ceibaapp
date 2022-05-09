package com.example.ceibaapp.model

import android.widget.TextView
import com.example.ceibaapp.R
import com.xwray.groupie.Item
import com.xwray.groupie.GroupieViewHolder

class UserItem(
    val user: User
): Item<GroupieViewHolder>() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val textViewAmount: TextView = viewHolder.itemView.findViewById(R.id.text_view_moto_transaccion)
        val textViewStatus: TextView = viewHolder.itemView.findViewById(R.id.text_view_referencia_transaccion)
        textViewAmount.text = user.name
        textViewStatus.text = user.email
    }

    override fun getLayout() = R.layout.user_item
}