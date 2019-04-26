package com.dany.coins

import android.content.ContentValues
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.dany.coins.Models.Coin
import com.dany.coins.Utils.AppConstants
import com.dany.coins.Utils.NetworkUtils
import com.dany.coins.data.Database
import com.dany.coins.data.DatabaseContract
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var dbHelper = Database(this)

    var twoPane =  false

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var gson = Gson()

    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
         FetchCoinTask().execute()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)


        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        if (fragment_content != null ){
            twoPane =  true
        }


    }

    fun initRecycler(coin:MutableList<Coin>) {
        if (twoPane){viewManager = LinearLayoutManager(this)}
        else{viewManager = GridLayoutManager(this,2)}

        viewAdapter = CoinAdapter(coin,{coinItem: Coin -> coinItemClicked(coinItem)})

        coin_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

    private inner class QueryCoinnTask : AsyncTask<String, Void, String>() {

        override fun doInBackground(vararg query: String): String {

            if (query.isNullOrEmpty()) return ""

            val ID = query[0]
            val coinAPI = NetworkUtils.buildUrl(ID)!!

            return try {
                NetworkUtils.getResponseFromHttpUrl(coinAPI)!!
            } catch (e: IOException) {
                e.printStackTrace()
                "Error :(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  "
            }

        }

        override fun onPostExecute(coinInfo: String) {
            val coin_list = if(!coinInfo.isEmpty()){
                val root = JSONArray(coinInfo)
                MutableList(root.length()){
                        i ->
                    val result = JSONObject(root[i].toString())
                    Coin(result.getString("name"),
                        result.getString("country"),
                        result.getDouble("value"),
                        result.getDouble("value_us"),
                        result.getInt("year"),
                        result.getString("review"),
                        result.getBoolean("isAvailable"),
                        result.getString("img"))
                }
            }else{
                MutableList(0) { i ->
                    Coin("","",0,0,0,"",false,"")
                }
            }

            initRecycler(coin_list)
        }
    }

    private fun coinItemClicked(item: Coin){
        val extras = Bundle()
        extras.putString(AppConstants.TEXT_KEY_NAME, item.name)
        extras.putString(AppConstants.TEXT_KEY_IMG, item.img)
        extras.putString(AppConstants.TEXT_KEY_IS_AVAILABLE,item.isAvailable.toString())
        extras.putString(AppConstants.TEXT_KEY_COUNTRY, item.country)
        extras.putString(AppConstants.TEXT_KEY_REVIEW,item.review)
        extras.putString(AppConstants.TEXT_KEY_YEAR,item.year.toString())
        extras.putString(AppConstants.TEXT_KEY_VALUE_US,item.value_us.toString())
        extras.putString(AppConstants.TEXT_KEY_VALUE,item.value.toString())
        startActivity(Intent(this, CoinViewer::class.java).putExtras(extras))
    }

    private inner class FetchCoinTask : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void): String? {
/*
            if (pokemonNumbers.isEmpty()) {
                return null
            }*/

            // val idPoke = pokemonNumbers[0


            val coinAPI = NetworkUtils.buildUrl("coins")!!


            return try {
                NetworkUtils.getResponseFromHttpUrl(coinAPI)
            } catch (e: IOException) {
                e.printStackTrace()
                "Error :(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  "
            }

        }

        override fun onPostExecute(coinInfo: String) {
            Log.d("CoinInfo",coinInfo)

            val root = JSONArray(coinInfo)

            for(i in 0..(root.length()-1)){

                val result = JSONObject(root[i].toString())

                val db = dbHelper.writableDatabase
                val values = ContentValues().apply {
                    put(DatabaseContract.CoinEntry.COLUMN_NAME, result.getString("name") )
                    put(DatabaseContract.CoinEntry.COLUMN_COUNTRY, result.getString("country"))
                    put(DatabaseContract.CoinEntry.COLUMN_VALUE, result.getDouble("value"))
                    put(DatabaseContract.CoinEntry.COLUMN_VALUE_US, result.getDouble("value_us"))
                    put(DatabaseContract.CoinEntry.COLUMN_YEAR, result.getInt("year"))
                    put(DatabaseContract.CoinEntry.COLUMN_REVIEW, result.getString("review"))
                    put(DatabaseContract.CoinEntry.COLUMN_ISAVAILABLE, result.getBoolean("isAvailable"))
                    put(DatabaseContract.CoinEntry.COLUMN_IMG, result.getString("img"))

                }

                val newRowId = db?.insert(DatabaseContract.CoinEntry.TABLE_NAME, null, values)

                if (newRowId == -1L) {
                    Snackbar.make(it, getString(R.string.coin_not_saved_message), Snackbar.LENGTH_SHORT).show()
                } else {
                    Snackbar.make(it, getString(R.string.coin_saved_message) + newRowId, Snackbar.LENGTH_SHORT)
                        .show()
                }
            }

            val coin_list = if(!coinInfo.isEmpty()){
                val root = JSONArray(coinInfo)
                MutableList(root.length()){
                    i ->
                    val result = JSONObject(root[i].toString())
                    Coin(result.getString("name"),
                        result.getString("country"),
                        result.getDouble("value"),
                        result.getDouble("value_us"),
                        result.getInt("year"),
                        result.getString("review"),
                        result.getBoolean("isAvailable"),
                        result.getString("img"))
                }
            }else{
                MutableList(0) { i ->
                    Coin("","",0,0,0,"",false,"")
                }
            }

            initRecycler(coin_list)
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

            R.id.nav_1 -> {
                QueryCoinnTask().execute("United States")
            }
            R.id.nav_2 -> {
                QueryCoinnTask().execute("Guatemala")
            }

            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}