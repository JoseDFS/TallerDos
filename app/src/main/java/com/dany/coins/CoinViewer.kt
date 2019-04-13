package com.dany.coins

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.AsyncTask.execute
import com.bumptech.glide.Glide
import android.content.Intent
import android.graphics.drawable.Drawable
import android.util.Log
import com.dany.coins.Utils.AppConstants
import kotlinx.android.synthetic.main.activity_coin_viewer.*


class CoinViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_viewer)


        val mIntent = intent
        if (mIntent != null) {



            Glide.with(this)
                    .load(mIntent.getStringExtra(AppConstants.TEXT_KEY_IMG))
                    .into(iv_coin2)

            tv_name.text = mIntent.getStringExtra(AppConstants.TEXT_KEY_NAME)
            tv_country.text =mIntent.getStringExtra(AppConstants.TEXT_KEY_COUNTRY)
            tv_isavailable.text =mIntent.getStringExtra(AppConstants.TEXT_KEY_IS_AVAILABLE)
            tv_value.text=mIntent.getStringExtra(AppConstants.TEXT_KEY_VALUE).toString()
            tv_valueus.text=mIntent.getStringExtra(AppConstants.TEXT_KEY_VALUE_US).toString()
            tv_year.text=mIntent.getStringExtra(AppConstants.TEXT_KEY_YEAR).toString()




        }

    }
}
