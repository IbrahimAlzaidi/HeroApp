package com.example.heroapp.ui.fragment.search

import android.view.LayoutInflater
import com.example.heroapp.databinding.FragmentSearchBinding
import com.example.heroapp.ui.fragment.base.BaseFragment
import com.example.heroapp.ui.fragment.base.BasePresenter


class SearchFragment : BaseFragment<FragmentSearchBinding, BasePresenter>() {

    override val LOG_TAG: String = "Search Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate

    override val selectedPresenter = SearchPresenter()

    override fun setup() {
        setAdapter()
    }

    private fun setAdapter() {
        //TODO("set data to recyclerView")
    }

    override fun addCallBack() {}

}