package com.example.classplussquad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.classplussquad.R
import com.example.classplussquad.model.TeamMember
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore

class TeamMatesFirebaseAdapter(options: FirestoreRecyclerOptions<TeamMember>) :
    FirestoreRecyclerAdapter<TeamMember, TeamMatesFirebaseAdapter.TeamMatesFirebaseViewHolder>(
        options
    ) {

    class TeamMatesFirebaseViewHolder (view: View):RecyclerView.ViewHolder(view){
        var name: TextView =view.findViewById(R.id.name_text)
        var level:TextView=view.findViewById(R.id.level_txt)
        var tech:TextView=view.findViewById(R.id.tech_text)
        var role:TextView=view.findViewById(R.id.role_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamMatesFirebaseViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.custom_layout_team_member,parent,false)
        return TeamMatesFirebaseViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TeamMatesFirebaseViewHolder,
        position: Int,
        model: TeamMember
    ) {
        holder.level.text=model.level
        holder.role.text=model.role
        holder.name.text=model.name
        holder.tech.text=model.tech
    }
}