package com.example.heroapp.ui.fragment.search

import android.view.LayoutInflater
import com.example.heroapp.databinding.FragmentSearchBinding
import com.example.heroapp.ui.fragment.base.BaseFragment


class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val LOG_TAG: String
        get() = "Main Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate

    override fun setup() {}
    override fun addCallBack() {}
}