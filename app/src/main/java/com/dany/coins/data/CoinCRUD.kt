package com.dany.coins.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.dany.coins.Models.Coin

class CoinCRUD(context: Context) {

    private var helper: Database? = null

    init {
        helper = Database(context)
    }

    fun newCoin(item:Coin){
        val db : SQLiteDatabase = helper?.writableDatabase!!

        //Mapeo de datos
        val values = ContentValues()
        values.put(DatabaseContract.CoinEntry.COLUMN_NAME, item.name)
        values.put(DatabaseContract.CoinEntry.COLUMN_COUNTRY, item.country)
        values.put(DatabaseContract.CoinEntry.COLUMN_VALUE, item.value)
        values.put(DatabaseContract.CoinEntry.COLUMN_VALUE_US, item.value_us)
        values.put(DatabaseContract.CoinEntry.COLUMN_YEAR, item.year)
        values.put(DatabaseContract.CoinEntry.COLUMN_REVIEW, item.review)
        values.put(DatabaseContract.CoinEntry.COLUMN_ISAVAILABLE, item.isAvailable)
        values.put(DatabaseContract.CoinEntry.COLUMN_IMG, item.img)

        //Insertar nueva fila
        val newRowId = db.insert(DatabaseContract.CoinEntry.TABLE_NAME,null,values)

        db.close()
    }

    fun getCoins() : ArrayList<Coin>{
        val items: ArrayList<Coin> = ArrayList()

        val db :SQLiteDatabase = helper?.readableDatabase!!

        val columns = arrayOf(DatabaseContract.CoinEntry.COLUMN_NAME,
            DatabaseContract.CoinEntry.COLUMN_COUNTRY,
            DatabaseContract.CoinEntry.COLUMN_VALUE,
            DatabaseContract.CoinEntry.COLUMN_VALUE_US,
            DatabaseContract.CoinEntry.COLUMN_YEAR,
            DatabaseContract.CoinEntry.COLUMN_REVIEW,
            DatabaseContract.CoinEntry.COLUMN_ISAVAILABLE,
            DatabaseContract.CoinEntry.COLUMN_IMG)

        val cursor: Cursor = db.query(DatabaseContract.CoinEntry.TABLE_NAME,
            columns,null,null,null,null,null)

        //Haciendo recorrido
        while (cursor.moveToNext()){
            items.add(Coin(
                cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_COUNTRY)),
                cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_VALUE)),
                cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_VALUE_US)),
                cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_YEAR)),
                cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_REVIEW)),
                cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_ISAVAILABLE)) > 0,
                cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_IMG))
            ))
        }
        db.close()
        return items
    }

    fun getCoinByName(name: String) : Coin{
        var item: Coin? = null

        val db :SQLiteDatabase = helper?.readableDatabase!!

        val columns = arrayOf(DatabaseContract.CoinEntry.COLUMN_NAME,
            DatabaseContract.CoinEntry.COLUMN_COUNTRY,
            DatabaseContract.CoinEntry.COLUMN_VALUE,
            DatabaseContract.CoinEntry.COLUMN_VALUE_US,
            DatabaseContract.CoinEntry.COLUMN_YEAR,
            DatabaseContract.CoinEntry.COLUMN_REVIEW,
            DatabaseContract.CoinEntry.COLUMN_ISAVAILABLE,
            DatabaseContract.CoinEntry.COLUMN_IMG)

        val cursor: Cursor = db.query(DatabaseContract.CoinEntry.TABLE_NAME,
            columns," name = ? ", arrayOf(name),null,null,null)

        //Haciendo recorrido
        while (cursor.moveToNext()){
            item = Coin(
                cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_COUNTRY)),
                cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_VALUE)),
                cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_VALUE_US)),
                cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_YEAR)),
                cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_REVIEW)),
                cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_ISAVAILABLE)) > 0,
                cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.CoinEntry.COLUMN_IMG))
            )
        }
        cursor.close()
        return item!!
    }

    fun updateCoin(item: Coin){
        val db: SQLiteDatabase = helper?.writableDatabase!!

        val values = ContentValues()
        values.put(DatabaseContract.CoinEntry.COLUMN_NAME, item.name)
        values.put(DatabaseContract.CoinEntry.COLUMN_COUNTRY, item.country)
        values.put(DatabaseContract.CoinEntry.COLUMN_VALUE, item.value)
        values.put(DatabaseContract.CoinEntry.COLUMN_VALUE_US, item.value_us)
        values.put(DatabaseContract.CoinEntry.COLUMN_YEAR, item.year)
        values.put(DatabaseContract.CoinEntry.COLUMN_REVIEW, item.review)
        values.put(DatabaseContract.CoinEntry.COLUMN_ISAVAILABLE, item.isAvailable)
        values.put(DatabaseContract.CoinEntry.COLUMN_IMG, item.img)

        db.update(DatabaseContract.CoinEntry.TABLE_NAME,values," name = ?", arrayOf(item.name))

        db.close()
    }

    fun deleteCoin(item: Coin){
        val db: SQLiteDatabase = helper?.writableDatabase!!

        db.delete(DatabaseContract.CoinEntry.TABLE_NAME," name = ?", arrayOf(item.name))

        db.close()
    }

}