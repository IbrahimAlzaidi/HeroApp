package com.example.heroapp.ui.fragment

import android.view.LayoutInflater
import com.example.heroapp.databinding.FragmentMainBinding


class MainFragment : BaseFragment<FragmentMainBinding>() {

    override val LOG_TAG: String
        get() = "Main Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentMainBinding =
        FragmentMainBinding::inflate

    override fun setup() {}
    override fun addCallBack() {}
}