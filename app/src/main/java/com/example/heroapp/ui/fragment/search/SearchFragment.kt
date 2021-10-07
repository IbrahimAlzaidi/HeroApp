package com.example.heroapp.ui.fragment.search

import android.view.LayoutInflater
import com.example.heroapp.databinding.FragmentSearchBinding
import com.example.heroapp.ui.fragment.base.BaseFragment
import com.example.heroapp.ui.fragment.base.BasePresenter


class SearchFragment : BaseFragment<FragmentSearchBinding, BasePresenter>() {

    override val LOG_TAG: String = "Main Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate

    override val selectedPresenter = SearchPresenter()

    override fun setup() {}

    override fun addCallBack() {}

}