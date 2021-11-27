package com.database

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.Pojo.Drug

class DatabaseAccess(context: Context) {
    private var database : SQLiteDatabase? = null
    private var openhelper : SQLiteOpenHelper? = null
    private var instance:DatabaseAccess ? = null

    init {
        this.openhelper = MyDatabase(context)
    }

    fun getInstance(context: Context):DatabaseAccess
    {
        if (instance == null)
        {
            instance = DatabaseAccess(context)
        }
        return instance!!
    }

    fun open()
    {
        this.database = this.openhelper!!.writableDatabase
    }

    fun close()
    {
        if (database != null)
        {
            this.database!!.close()
        }
    }

    @SuppressLint("Range")
    fun get_All_Drugs(): ArrayList<Drug> {
        val array_drugs = arrayListOf<Drug>()
        val cursor: Cursor = database!!.rawQuery("SELECT * FROM $TABLE_NAME/*ORDER BY column_ID DESC*/", null)
        while (cursor.moveToNext()) {

                val ID: String = cursor.getString(cursor.getColumnIndex(D_ID))
                val NE = cursor.getString(cursor.getColumnIndex(D_NE))
                val CODE = cursor.getString(cursor.getColumnIndex(D_CODE))
                val NI = cursor.getString(cursor.getColumnIndex(D_N_I))
                val NM = cursor.getString(cursor.getColumnIndex(D_NM))
                val F = cursor.getString(cursor.getColumnIndex(D_F))
                val D = cursor.getString(cursor.getColumnIndex(D_D))
                val C = cursor.getString(cursor.getColumnIndex(D_C))
                val L = cursor.getString(cursor.getColumnIndex(D_L))
                val P1 = cursor.getString(cursor.getColumnIndex(D_P1))
                val P2 = cursor.getString(cursor.getColumnIndex(D_P2))
                val OBS = cursor.getString(cursor.getColumnIndex(D_OBS))
                val LDLD = cursor.getString(cursor.getColumnIndex(D_LDLD))
                val PLDDD = cursor.getString(cursor.getColumnIndex(D_PLDDD))
                val DEI = cursor.getString(cursor.getColumnIndex(D_DEI))
                val DDF = cursor.getString(cursor.getColumnIndex(D_DDF))
                val TYPE = cursor.getString(cursor.getColumnIndex(D_TYPE))
                val S = cursor.getString(cursor.getColumnIndex(D_S))
                val DDS = cursor.getString(cursor.getColumnIndex(D_DDS))
                val EMPTYFILD = cursor.getString(cursor.getColumnIndex(D_EMPTYFILD))
                val TW = cursor.getString(cursor.getColumnIndex(D_TW))

                val drug= Drug(ID ,NE ,CODE ,NI ,NM ,F ,D ,C ,L ,P1 ,P2 ,OBS ,LDLD ,PLDDD ,DEI ,DDF ,TYPE ,S ,DDS ,EMPTYFILD ,TW)

                array_drugs.add(drug)
        }
        cursor.close()

        return array_drugs
    }
}