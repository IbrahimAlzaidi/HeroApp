package com.example.heroapp.ui.fragment.details

import android.view.LayoutInflater
import android.view.View
import com.example.heroapp.databinding.FragmentDetailsBinding
import com.example.heroapp.ui.fragment.base.BaseFragment
import com.example.heroapp.ui.fragment.base.BasePresenter

class DetailsFragment : BaseFragment<FragmentDetailsBinding, BasePresenter>() {

    override val LOG_TAG: String = "Details Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding =
        FragmentDetailsBinding::inflate

    override val selectedPresenter = DetailsPresenter()

    override fun setup() {}

    override fun addCallBack() {}

    override fun hideAllViews() {
    }


}
