package com.main.drugsdz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.Pojo.Drug
import com.adapter.Drugs_Adapter
import com.adapter.SetOnClickItem
import com.database.DatabaseAccess
import com.example.drugsdz.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.l4digital.fastscroll.FastScrollRecyclerView
import com.l4digital.fastscroll.FastScrollView
import java.util.*


class MainActivity : AppCompatActivity() {

    var database:DatabaseAccess?= null
    var rv:FastScrollRecyclerView? = null
    private var adapter:Drugs_Adapter? = null
    var lm:LinearLayoutManager? = null
    private var bu_totop:FloatingActionButton? = null
    var appbar:AppBarLayout? = null
    var searchbar:SearchView? = null
    var fastScroller:FastScrollView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        appbar = findViewById(R.id.drug_appbar)

        bu_totop = findViewById(R.id.bu_t_top)

        searchbar = findViewById(R.id.drugs_searchbar)

        database = DatabaseAccess(this).getInstance(this)

        adapter = Drugs_Adapter(this)

        database!!.open()
        val drugs = database!!.get_All_Drugs()
        database!!.close()

        rv = findViewById(R.id.rv_drugs)

        adapter!!.onclikdrug(object :SetOnClickItem{
            override fun onItemClikc(drug: Drug) {
//                Toast.makeText(this@MainActivity ,drug.D_NM , Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity ,Details_Drug::class.java)
                intent.putExtra("drug" ,drug)
                startActivity(intent)
            }

        })
        lm  = LinearLayoutManager(this)

        adapter!!.setList(drugs)

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

                adapter!!.filter(newText.toString() ,drugs)
                return true
            }

        })

    }

}