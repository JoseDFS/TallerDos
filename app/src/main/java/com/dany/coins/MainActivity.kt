package com.dany.coins

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.dany.coins.Models.Coin
import com.dany.coins.Utils.AppConstants
import com.dany.coins.Utils.NetworkUtils
import com.dany.coins.data.CoinCRUD
import com.dany.coins.fragments.MainContentFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    var twoPane = false

    var crud: CoinCRUD? = CoinCRUD(this)

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var mainContentFragment: MainContentFragment

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



        if (fragment_content != null) {
            twoPane = true
            mainContentFragment = MainContentFragment.newInstance(Coin())
            supportFragmentManager.beginTransaction().replace(R.id.fragment_content, mainContentFragment).commit()
        }


    }

    fun initRecycler(coin: MutableList<Coin>) {
        if (twoPane) {
            viewManager = LinearLayoutManager(this)
        } else {
            viewManager = GridLayoutManager(this, 2)

        }

        viewAdapter = CoinAdapter(coin, { coinItem: Coin -> coinItemClicked(coinItem) })

        coin_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }


    private fun coinItemClicked(item: Coin) {
        if (twoPane) {
            mainContentFragment = MainContentFragment.newInstance(item)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_content, mainContentFragment).commit()
        } else {
            val extras = Bundle()
            extras.putString(AppConstants.TEXT_KEY_NAME, item.name)
            extras.putString(AppConstants.TEXT_KEY_IMG, item.img)
            extras.putString(AppConstants.TEXT_KEY_IS_AVAILABLE, item.isAvailable.toString())
            extras.putString(AppConstants.TEXT_KEY_COUNTRY, item.country)
            extras.putString(AppConstants.TEXT_KEY_REVIEW, item.review)
            extras.putString(AppConstants.TEXT_KEY_YEAR, item.year.toString())
            extras.putString(AppConstants.TEXT_KEY_VALUE_US, item.value_us.toString())
            extras.putString(AppConstants.TEXT_KEY_VALUE, item.value.toString())
            startActivity(Intent(this, CoinViewer::class.java).putExtras(extras))
        }
    }

    private inner class FetchCoinTask : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void): String? {

            val coinAPI = NetworkUtils.buildUrl("coins")!!

            return try {
                if (crud?.getCoins().isNullOrEmpty()) {
                    NetworkUtils.getResponseFromHttpUrl(coinAPI)

                } else {
                    crud?.getCoins().toString()

                }

            } catch (e: IOException) {
                e.printStackTrace()
                "Error :(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  "
            }

        }

        override fun onPostExecute(coinInfo: String) {
            Log.d("CoinInfo", coinInfo)
            if (crud?.getCoins()?.isNotEmpty()!!) {
                Log.d("IF", coinInfo)
                initRecycler(crud?.getCoins()!!)

            } else {
                val root = JSONArray(coinInfo)
                Log.d("Hola", root.toString())
                for (i in 0..(root.length() - 1)) {
                    val res = JSONObject(root[i].toString())

                    crud?.newCoin(
                        Coin(
                            res.getString("name"),
                            res.getString("country"),
                            res.getDouble("value"),
                            res.getDouble("value_us"),
                            res.getInt("year"),
                            res.getString("review"),
                            res.getBoolean("isAvailable"),
                            res.getString("img")
                        )
                    )

                }
                initRecycler(crud?.getCoins()!!)
            }

        }
    }
}
