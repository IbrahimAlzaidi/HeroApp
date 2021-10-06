package com.example.heroapp.ui.fragment.details

import android.view.LayoutInflater
import com.example.heroapp.databinding.FragmentDetailsBinding
import com.example.heroapp.ui.fragment.base.BaseFragment

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val LOG_TAG: String
        get() = "Details Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding =
        FragmentDetailsBinding::inflate

    override fun setup() {}
    override fun addCallBack() {}
}