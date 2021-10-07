package com.example.heroapp.ui.fragment.search

import android.view.LayoutInflater
import com.example.heroapp.databinding.FragmentSearchBinding
import com.example.heroapp.model.response.heroImageModel.HeroImage
import com.example.heroapp.ui.fragment.base.BaseAdapter
import com.example.heroapp.ui.fragment.base.BaseFragment


class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val LOG_TAG: String
        get() = "Main Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate

    override fun setup() {
        setAdapter()
    }

    private fun setAdapter() {
       //TODO("set data to recyclerView")
    }


    override fun addCallBack() {}

}