package com.example.heroapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.heroapp.R
import com.example.heroapp.databinding.RecyclerViewItemBinding
import com.example.heroapp.databinding.ViewPagerItemBinding
import com.example.heroapp.model.response.heroImageModel.HeroImage
import com.example.heroapp.model.response.heroModel.Heros

class ViewPagerAdapter(private val heroDate: Heros) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder =
        ViewPagerHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_, parent, false)
        )

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val current = heroDate.results?.get(position)
        holder.binding.apply {
            myHeroName.text = current?.name.toString()
            Glide.with(myImageHero).load(current?.image?.url.toString()).into(myImageHero)
        }
    }

    override fun getItemCount() = heroDate.results!!.size

    inner class ViewPagerHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = RecyclerViewItemBinding.bind(itemView)
    }
}
