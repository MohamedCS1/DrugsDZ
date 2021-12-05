package com.main.drugsdz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.Pojo.Drug
import com.example.drugsdz.R

class Details_Drug : AppCompatActivity(){

   var tv_D_NE: TextView? = null
   var tv_D_CODE: TextView? = null
   var tv_D_N_I: TextView? = null
   var tv_D_NM: TextView? = null
   var tv_D_F: TextView? = null
   var tv_D_D: TextView? = null
   var tv_D_C: TextView? = null
   var tv_D_L: TextView? = null
   var tv_D_P1: TextView? = null
   var tv_D_P2: TextView? = null
   var tv_D_OBS: TextView? = null
   var tv_D_LDLD: TextView? = null
   var tv_D_PLDDD: TextView? = null
   var tv_D_DEI: TextView? = null
   var tv_D_DDF: TextView? = null
   var tv_D_TYPE: TextView? = null
   var tv_D_S: TextView? = null
   var tv_D_DDS: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_drug)

        val intent = intent.extras
        val drug = intent?.get("drug") as Drug

        tv_D_NE = findViewById(R.id.tv_D_NE)
        tv_D_CODE = findViewById(R.id.tv_D_CODE)
        tv_D_N_I = findViewById(R.id.tv_D_N_I)
        tv_D_NM = findViewById(R.id.tv_D_NM)
        tv_D_F = findViewById(R.id.tv_D_F)
        tv_D_D = findViewById(R.id.tv_D_D)
        tv_D_C = findViewById(R.id.tv_D_C)
        tv_D_L = findViewById(R.id.tv_D_L)
        tv_D_P1 = findViewById(R.id.tv_D_P1)
        tv_D_P2 = findViewById(R.id.tv_D_P2)
        tv_D_OBS = findViewById(R.id.tv_D_OBS)
        tv_D_LDLD = findViewById(R.id.tv_D_LDLD)
        tv_D_PLDDD = findViewById(R.id.tv_D_PLDDD)
        tv_D_DEI = findViewById(R.id.tv_D_DEI)
        tv_D_DDF = findViewById(R.id.tv_D_DDF)
        tv_D_TYPE = findViewById(R.id.tv_D_TYPE)
        tv_D_S = findViewById(R.id.tv_D_S)
        tv_D_DDS = findViewById(R.id.tv_DDS)

        tv_D_NE!!.text = drug.D_NE
        tv_D_CODE!!.text = drug.D_CODE
        tv_D_N_I!!.text = drug.D_N_I
        tv_D_NM!!.text = drug.D_NM
        tv_D_F!!.text = drug.D_F
        tv_D_D!!.text = drug.D_D
        tv_D_C!!.text = drug.D_C
        tv_D_L!!.text = drug.D_L
        tv_D_P1!!.text = drug.D_P1
        tv_D_P2!!.text = drug.D_P2
        tv_D_OBS!!.text = drug.D_OBS
        tv_D_LDLD!!.text = drug.D_LDLD
        tv_D_PLDDD!!.text = drug.D_PLDDD
        tv_D_DEI!!.text = drug.D_DEI
        tv_D_DDF!!.text = drug.D_DDF
        tv_D_TYPE!!.text = drug.D_TYPE
        tv_D_S!!.text = drug.D_S
        tv_D_DDS!!.text = drug.D_DDS


    }

}
