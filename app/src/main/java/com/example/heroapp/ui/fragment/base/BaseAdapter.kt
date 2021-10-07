package com.example.heroapp.ui.fragment.base

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.heroapp.R
import com.example.heroapp.databinding.ItemHeroBinding
import com.example.heroapp.model.response.heroImageModel.HeroImage

class BaseAdapter(private val heroListData: HeroImage) : RecyclerView.Adapter<BaseAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroViewHolder(view)
    }
    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.binding.apply {
            heroName.text = heroListData.name
            Log.i("recyclerView",heroListData.url.toString())
            Glide.with(heroImage).load(heroListData.url.toString()).into(heroImage)
        }
    }
    override fun getItemCount() = heroListData.id!!.count()


    class HeroViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemHeroBinding.bind(viewItem)

    }
}