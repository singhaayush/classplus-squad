package com.example.classplussquad.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classplussquad.R
import com.example.classplussquad.adapters.TeamMatesFirebaseAdapter
import com.example.classplussquad.model.TeamMember
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    lateinit var db:FirebaseFirestore
    lateinit var cReference:CollectionReference
    var teamMatesList=ArrayList<TeamMember>()
    lateinit var adapter: TeamMatesFirebaseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db= FirebaseFirestore.getInstance()
        cReference=db.collection("tech_team")
       // getAllTeamMembers()
        setUpRecyclerView()

        teammates_rec.layoutManager=LinearLayoutManager(this)


    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    private fun setUpRecyclerView()
    {
       var query=cReference
        var options:FirestoreRecyclerOptions<TeamMember> = FirestoreRecyclerOptions.Builder<TeamMember>()
            .setQuery(query,TeamMember::class.java)
            .build()

        adapter=TeamMatesFirebaseAdapter(options)
        teammates_rec.adapter=adapter
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }
}