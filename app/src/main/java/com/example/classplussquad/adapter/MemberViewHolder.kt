package com.example.classplussquad.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.classplussquad.R

class MemberViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var name: TextView
    var role: TextView
    var tech: TextView
    var level: TextView

    init {
        name = view.findViewById(R.id.title)
        role = view.findViewById(R.id.role)

        tech = view.findViewById(R.id.tech)
        level = view.findViewById(R.id.level)
    }
}
