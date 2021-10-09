package com.example.heroapp.ui.fragment.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.heroapp.R
import com.example.heroapp.databinding.ItemHeroBinding
import com.example.heroapp.model.response.heroModel.SuperHeroResponse

class SearchAdapter(private val heroDate: SuperHeroResponse, private val listener: IItemListener) :
    RecyclerView.Adapter<SearchAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder =
        RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        )

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val current = heroDate.results?.get(position)
        holder.binding.apply {
            heroName.text = current?.name.toString()
            publisherName.text = current?.biography?.publisher
            firstAppearance.text = current?.biography?.firstAppearance.toString()
            constraintLayout.startAnimation(setRecyclerAnimation(holder))
            Glide.with(heroImage).load(current?.image?.url.toString()).into(heroImage)
            transition.setOnClickListener { listener.onItemClickListener(current) }
        }
    }
    private fun setRecyclerAnimation(holder: RecyclerViewHolder) =
        AnimationUtils.loadAnimation(holder.itemView.context, android.R.anim.slide_in_left)


    override fun getItemCount() = heroDate.results!!.size

    inner class RecyclerViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemHeroBinding.bind(itemView)
    }
}
