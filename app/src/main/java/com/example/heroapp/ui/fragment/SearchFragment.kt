package com.example.heroapp.ui.fragment

import android.view.LayoutInflater
import com.example.heroapp.databinding.FragmentSearchBinding
import com.example.heroapp.ui.base.BaseFragment


class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val LOG_TAG: String
        get() = "Main Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate

    override fun setup() {}
    override fun addCallBack() {}
}