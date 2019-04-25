package com.dany.coins.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

private const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${DatabaseContract.CoinEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${DatabaseContract.CoinEntry.COLUMN_NAME} TEXT," +
                "${DatabaseContract.CoinEntry.COLUMN_COUNTRY} TEXT," +
                "${DatabaseContract.CoinEntry.COLUMN_VALUE} TEXT," +
                "${DatabaseContract.CoinEntry.COLUMN_VALUEUS} TEXT," +
                "${DatabaseContract.CoinEntry.COLUMN_YEAR} TEXT," +
                "${DatabaseContract.CoinEntry.COLUMN_REVIEW} TEXT," +
                "${DatabaseContract.CoinEntry.COLUMN_ISAVAILABLE} TEXT," +
                "${DatabaseContract.CoinEntry.COLUMN_IMG} TEXT)"

private const val SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS ${DatabaseContract.CoinEntry.TABLE_NAME}"



class Database (context : Context) : SQL
iteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION){
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }



    companion object{
        const val DATABASE_NAME = "miprimerabase.db"
        const val DATABASE_VERSION = "1"
    }

}