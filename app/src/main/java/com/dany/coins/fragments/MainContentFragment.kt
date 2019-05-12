package com.dany.coins.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.dany.coins.Models.Coin
import com.dany.coins.R
import kotlinx.android.synthetic.main.coin_model.view.*
import kotlinx.android.synthetic.main.main_fragment_coin.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MainContentFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MainContentFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MainContentFragment : Fragment() {
    var coin = Coin()

    companion object {
        fun newInstance(coin: Coin): MainContentFragment{
            val newFragment = MainContentFragment()
            newFragment.coin = coin
            return newFragment
        }
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.main_fragment_coin, container, false)

        bindData(view)

        return view
    }

    fun bindData(view: View){

        view.tv_country.text=coin.country
        view.tv_isavailable.text=coin.isAvailable.toString()
        view.tv_name.text=coin.name
        view.tv_review.text=coin.review
        view.tv_value.text=coin.value.toString()
        view.tv_valueus.text=coin.value_us.toString()
        view.tv_year.text=coin.year.toString()



        //view.types_main_content_fragment.text = pokemon.types
        Glide.with(view)
            .load(coin.img)
            .placeholder(R.drawable.ic_launcher_background)
            .into(view.iv_coin2)
    }
}
