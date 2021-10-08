package com.example.heroapp.ui.fragment.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.heroapp.R
import com.example.heroapp.databinding.ItemHeroBinding
import com.example.heroapp.model.response.heroModel.Heros
import com.example.heroapp.model.response.heroModel.Result
import com.example.heroapp.util.CardViewListener

class BaseAdapter(private val heroListData: Heros, private val listener: CardViewListener) :
    RecyclerView.Adapter<BaseAdapter.HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        when (holder) {
            is HeroViewHolder -> bindData(holder, heroListData.results?.get(position))
        }
    }

    private fun bindData(holder: HeroViewHolder, hero: Result?) {
        holder.binding.apply {
            heroName.text = hero?.name
            Glide.with(heroImage).load(hero?.image?.url).into(heroImage)
            setRecyclerAnimation(holder)
            myCardView.apply {
                startAnimation(setRecyclerAnimation(holder))
                setOnClickListener { listener.onCardClicked(hero) }
            }
        }
    }

    private fun setRecyclerAnimation(holder: HeroViewHolder) =
        AnimationUtils.loadAnimation(holder.itemView.context, android.R.anim.slide_in_left)

    override fun getItemCount() = heroListData.results!!.count()


    class HeroViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemHeroBinding.bind(viewItem)

    }
}
