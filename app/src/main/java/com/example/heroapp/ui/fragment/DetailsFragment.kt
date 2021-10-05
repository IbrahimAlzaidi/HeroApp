package com.example.heroapp.ui.fragment

import android.view.LayoutInflater
import com.example.heroapp.databinding.FragmentDetailsBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val LOG_TAG: String = "Details Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding =
        FragmentDetailsBinding::inflate

    override fun setup() {}
    override fun addCallBack() {}
}
