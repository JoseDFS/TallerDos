package com.dany.coins

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.dany.coins.Models.Coin
import kotlinx.android.synthetic.main.coin_model.view.*


class CoinAdapter(var items:List<Coin>,val clickListener: (Coin)->Unit) :RecyclerView.Adapter<CoinAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.coin_model,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CoinAdapter.ViewHolder, position: Int) {
        holder.bind(items[position],clickListener)




    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Coin,clickListener: (Coin) -> Unit) = with(itemView) {
            Glide.with(itemView.context)
                .load(item.img)
                .into(itemView.image_coin)

            name_coin.text = item.name
            this.setOnClickListener{clickListener(item)}

        }
    }

}