package com.example.classplussquad.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classplussquad.R
import com.example.classplussquad.adapters.TeamMatesAdapter
import com.example.classplussquad.model.TeamMember
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    lateinit var db:FirebaseFirestore
    lateinit var cReference:CollectionReference
    var teamMatesList=ArrayList<TeamMember>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db= FirebaseFirestore.getInstance()
        cReference=db.collection("tech_team")
        getAllTeamMembers()

        teammates_rec.layoutManager=LinearLayoutManager(this)


    }
    private fun getAllTeamMembers(){
        cReference.get().addOnSuccessListener(object :OnSuccessListener<QuerySnapshot>{
            override fun onSuccess(querySnapshot: QuerySnapshot?) {
                if (querySnapshot != null) {
                    for(queryDocumentSnapshot in querySnapshot)
                    {
                        var teamMember:TeamMember=queryDocumentSnapshot.toObject(TeamMember::class.java)
                        teamMatesList.add(teamMember)
                    }

                    var teamMatesAdapter=TeamMatesAdapter(teamMatesList)
                    teammates_rec.adapter=teamMatesAdapter
                }
            }

        })
    }
}