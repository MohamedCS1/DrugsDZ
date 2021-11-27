package com.database

import android.content.Context
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

  const val DB_NAME:String = "drugs.db"
  const val DB_VERSION:Int = 1
  const val TABLE_NAME = "Drugs"
  const val D_ID = "N°"
  const val D_NE = "N°ENREGISTREMENT"
  const val D_CODE = "CODE"
  const val D_N_I = "DENOMINATION COMMUNE INTERNATIONALE"
  const val D_NM = "NOM DE MARQUE"
  const val D_F = "FORME"
  const val D_D = "DOSAGE"
  const val D_C = "COND"
  const val D_L = "LISTE"
  const val D_P1 = "P1"
  const val D_P2 = "P2"
  const val D_OBS = "OBS"
  const val D_LDLD = "LABORATOIRES DETENTEUR DE LA DECISION D'ENREGISTREMENT"
  const val D_PLDDD = "PAYS DU LABORATOIRE DETENTEUR DE LA DECISION D'ENREGISTREMENT"
  const val D_DEI = "DATE D'ENREGISTREMENT INITIAL"
  const val D_DDF = "DATE D'ENREGISTREMENT  FINAL"
  const val D_TYPE = "TYPE"
  const val D_S = "STATUT"
  const val D_DDS = "DUREE DE STABILITE"
  const val D_EMPTYFILD = ""
  const val D_TW = "2"

class MyDatabase(context: Context) : SQLiteAssetHelper(context, DB_NAME, null, DB_VERSION) {

}