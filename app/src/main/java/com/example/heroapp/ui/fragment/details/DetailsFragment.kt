package com.example.heroapp.ui.fragment.details

import android.view.LayoutInflater
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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
        binding?.apply {
            heroName.text = args.details.name
            publisher.text = args.details.biography?.publisher
            powerStats.text = args.details.powerstats?.power
            fullName.text = "FullName : ${args.details.biography?.fullName}"
            placeOfBirth.text = "Place Of Birth : ${args.details.biography?.placeOfBirth}"
            firstAppearance.text = "FirstAppearance : ${args.details.biography?.firstAppearance}"
            Glide.with(this@DetailsFragment).load(args.details.image?.url).into(heroImage)
        }
    }

    override fun addCallBack() {}
    override fun onDataDetailsFlow(hero: Flow<State<SuperHeroResponse>?>) {}
    override fun hideAllViews() {}
}
