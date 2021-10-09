package com.example.heroapp.ui.fragment.details

import android.view.LayoutInflater
import androidx.navigation.fragment.navArgs
import com.example.heroapp.databinding.FragmentDetailsBinding
import com.example.heroapp.model.response.heroModel.SuperHeroResponse
import com.example.heroapp.ui.fragment.base.BaseFragment
import com.example.heroapp.ui.fragment.base.BasePresenter
import com.example.heroapp.util.State
import kotlinx.coroutines.flow.Flow

class DetailsFragment : BaseFragment<FragmentDetailsBinding, BasePresenter>(), IDetailsView {

    override val LOG_TAG: String = "Details Fragment"
    val args: DetailsFragmentArgs by navArgs()

    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding =
        FragmentDetailsBinding::inflate

    override val selectedPresenter = DetailsPresenter(this)

    override fun setup() {
        "args.details.appearance?.eyeColor"  // this line make you show this details at ui
     }

    override fun addCallBack() {}

    override fun onDataDetailsFlow(hero: Flow<State<SuperHeroResponse>>) {

    }

    override fun hideAllViews() {
    }


}
