package com.dany.coins

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dany.coins.Utils.Coin_dummy
import kotlinx.android.synthetic.main.coin_model.view.*


class CoinAdapter(var items:List<Coin_dummy>) :RecyclerView.Adapter<CoinAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.coin_model,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CoinAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Coin_dummy) = with(itemView) {

            name_coin.text = item.name

        }
    }

}