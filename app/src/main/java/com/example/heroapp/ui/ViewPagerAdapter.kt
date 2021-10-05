package com.example.heroapp.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.heroapp.R
import com.example.heroapp.databinding.ViewPagerItemBinding
import com.example.heroapp.ui.model.heroImageModel.HeroImage

class ViewPagerAdapter(
    private val listDate: MutableList<HeroImage>,
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder =
        ViewPagerHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val current = listDate[position]
        Log.i("ViewPagerAdapter", current.url.toString())
        holder.binding.apply {
            heroName.text = current.name
            Glide.with(heroImage).load(current.url).into(heroImage)
        }
    }

//    private fun bindLayout(holder: ViewPagerHolder, image: Char) {
//        holder.binding.apply {
//            this.heroName.text = image.toString()
//            Glide.with(heroImage)
//                .load(image)
//                .into(heroImage)
//        }
//    }

    override fun getItemCount() = listDate.size

    inner class ViewPagerHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ViewPagerItemBinding.bind(itemView)
    }
}
