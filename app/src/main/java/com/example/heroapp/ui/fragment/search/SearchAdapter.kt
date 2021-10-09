package com.example.heroapp.ui.fragment.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.heroapp.R
import com.example.heroapp.databinding.ItemHeroBinding
import com.example.heroapp.model.response.heroModel.Heros

class SearchAdapter(private val heroDate: Heros, private val listener: IItemListener) :
    RecyclerView.Adapter<SearchAdapter.ViewPagerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder =
        ViewPagerHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        )

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val current = heroDate.results?.get(position)
        holder.binding.apply {
            heroName.text = current?.name.toString()
            Glide.with(heroImage).load(current?.image?.url.toString()).into(heroImage)
            constraintLayout.setOnClickListener { listener.onCardClicked(current) }
        }
    }

    override fun getItemCount() = heroDate.results!!.size

    inner class ViewPagerHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemHeroBinding.bind(itemView)
    }
}
