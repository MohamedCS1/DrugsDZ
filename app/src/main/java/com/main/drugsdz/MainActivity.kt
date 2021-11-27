package com.main.drugsdz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.database.DatabaseAccess
import com.example.drugsdz.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = DatabaseAccess(this).getInstance(this)
        database.open()
        val drusgs = database.getAll_Drugs()
        database.close()

        for (drug in drusgs)
        {
            Log.d("sqlite" , drug.toString())
        }

    }
}