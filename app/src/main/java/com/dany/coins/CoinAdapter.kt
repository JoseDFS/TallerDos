package com.dany.coins

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.dany.coins.models.Coin
import kotlinx.android.synthetic.main.cardview_coin.view.*

class CoinAdapter (val items: List<Coin>, val clickListener: (Coin) -> Unit): RecyclerView.Adapter<CoinAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_coin, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount()=items.size

    override fun onBindViewHolder(holder: CoinAdapter.ViewHolder, position: Int) = holder.bind(items[position], clickListener)

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: Coin, clickListener: (Coin) -> Unit) = with(itemView) {
            tv_coin_name.text = item.name
            tv_coin_country.text = item.country
            this.setOnClickListener { clickListener(item) }
        }
    }
}