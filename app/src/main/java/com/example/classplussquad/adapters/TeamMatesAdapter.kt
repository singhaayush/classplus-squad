package com.example.classplussquad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.classplussquad.R
import com.example.classplussquad.model.TeamMember

class TeamMatesAdapter(private val teamMates:List<TeamMember>):
    RecyclerView.Adapter<TeamMatesAdapter.TeamMatesViewHolder>() {

    class TeamMatesViewHolder(view:View):RecyclerView.ViewHolder(view)
    {
          var name:TextView=view.findViewById(R.id.name_text)
          var level:TextView=view.findViewById(R.id.level_txt)
          var tech:TextView=view.findViewById(R.id.tech_text)
          var role:TextView=view.findViewById(R.id.role_txt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMatesViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.custom_layout_team_member,parent,false)
        return TeamMatesViewHolder(view)
    }

    override fun getItemCount(): Int {
       return teamMates.size
    }

    override fun onBindViewHolder(holder: TeamMatesViewHolder, position: Int) {
        holder.level.text=teamMates[position].level
        holder.role.text=teamMates[position].role
        holder.name.text=teamMates[position].name
        holder.tech.text=teamMates[position].tech
    }
}