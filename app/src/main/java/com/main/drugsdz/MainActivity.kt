package com.main.drugsdz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adapter.Drugs_Adapter
import com.database.DatabaseAccess
import com.example.drugsdz.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var database:DatabaseAccess?= null
    var rv:RecyclerView? = null
    var adapter:Drugs_Adapter? = null
    var lm:LinearLayoutManager? = null
    var bu_totop:FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bu_totop = findViewById(R.id.bu_t_top)

        database = DatabaseAccess(this).getInstance(this)

        database!!.open()
        val drusgs = database!!.getAll_Drugs()
        database!!.close()

        rv = findViewById(R.id.rv_drugs)

        adapter = Drugs_Adapter()

        lm  = LinearLayoutManager(this)

        adapter!!.setList(drusgs)

        rv!!.adapter = adapter

        rv!!.layoutManager = lm

        bu_totop!!.setOnClickListener {
            rv!!.smoothScrollToPosition(0)
        }
    }
}