package com.example.classplussquad.ui

import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classplussquad.adapter.MemberViewHolder
import com.example.classplussquad.datamodel.UserDataModel
import com.example.classplussquad.R
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class StartActivity : AppCompatActivity() {

    private val TAG = "StartActivity"
    lateinit var db: FirebaseFirestore
    lateinit var query: CollectionReference
    lateinit var adapter: FirestoreRecyclerAdapter<UserDataModel, MemberViewHolder>


    private var teamList = mutableListOf<UserDataModel>()
    private lateinit var teamListView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance()
        query = db.collection("tech_team")

        teamListView = findViewById<RecyclerView>(R.id.users_list)

        val response = FirestoreRecyclerOptions.Builder<UserDataModel>()
            .setQuery(query, UserDataModel::class.java)
            .build()


        adapter = object : FirestoreRecyclerAdapter<UserDataModel, MemberViewHolder>(response) {

            override fun onBindViewHolder(
                holder: MemberViewHolder,
                position: Int,
                model: UserDataModel
            ) {
                //val member = teamList[position]
                holder.name.text = model.name
                holder.level.text = model.level
                holder.role.text = model.role
                holder.tech.text = model.tech
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
                return MemberViewHolder(view)
            }
        }

        val mLayoutManager = GridLayoutManager(this, 2)
        teamListView.layoutManager = mLayoutManager
        teamListView.itemAnimator = DefaultItemAnimator()

        adapter!!.notifyDataSetChanged()
        teamListView.adapter = adapter

        }

    override fun onStart() {
        super.onStart()
        adapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter!!.stopListening()
    }

}