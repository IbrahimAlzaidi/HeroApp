package com.example.heroapp.ui.fragment.details

import android.view.LayoutInflater
import androidx.navigation.fragment.navArgs
import com.example.heroapp.databinding.FragmentDetailsBinding
import com.example.heroapp.ui.fragment.base.BaseFragment
import com.example.heroapp.ui.fragment.base.BasePresenter

class DetailsFragment : BaseFragment<FragmentDetailsBinding, BasePresenter>() {

    override val LOG_TAG: String = "Details Fragment"
    val args: DetailsFragmentArgs by navArgs()

    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding =
        FragmentDetailsBinding::inflate

    override val selectedPresenter = DetailsPresenter()

    override fun setup() {
        "args.details.appearance?.eyeColor"  // this line make you show this details at ui
     }

    override fun addCallBack() {}

    override fun hideAllViews() {
    }


}
