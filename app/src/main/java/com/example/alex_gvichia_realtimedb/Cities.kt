package com.example.alex_gvichia_realtimedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_cities.*

class Cities : AppCompatActivity() {
    val arr : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        FirebaseDatabase.getInstance().reference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                for (i in p0.children)
                {
                    arr.add(i.key.toString())
                }

                val adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_list_item_1, arr)
                list.adapter = adapter
            }

        })
    }
}
