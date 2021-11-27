package com.main.drugsdz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Pojo.Drug
import com.adapter.Drugs_Adapter
import com.database.DatabaseAccess
import com.example.drugsdz.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var database:DatabaseAccess?= null
    var rv:RecyclerView? = null
    private var adapter:Drugs_Adapter? = null
    var lm:LinearLayoutManager? = null
    private var bu_totop:FloatingActionButton? = null
    var appbar:AppBarLayout? = null
    var searchbar:SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appbar = findViewById(R.id.drug_appbar)

        bu_totop = findViewById(R.id.bu_t_top)

        searchbar = findViewById(R.id.drugs_searchbar)

        database = DatabaseAccess(this).getInstance(this)

        database!!.open()
        val drusgs = database!!.get_All_Drugs()
        database!!.close()

        rv = findViewById(R.id.rv_drugs)

        adapter = Drugs_Adapter(this)

        lm  = LinearLayoutManager(this)

        adapter!!.setList(drusgs)

        rv!!.adapter = adapter

        rv!!.layoutManager = lm

        bu_totop!!.setOnClickListener {
            rv!!.smoothScrollToPosition(0)
        }

        appbar!!.setOnClickListener {
            searchbar!!.setIconifiedByDefault(false)
        }

        searchbar!!.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter!!.filter(newText.toString() ,drusgs)
                return true
            }

        })
    }
}