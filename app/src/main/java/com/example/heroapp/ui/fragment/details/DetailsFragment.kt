package com.example.heroapp.ui.fragment.details

import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.bumptech.glide.Glide
import com.example.heroapp.R
import com.example.heroapp.databinding.FragmentDetailsBinding
import com.example.heroapp.model.response.heroModel.SuperHeroPowerstats
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

    override fun onDataDetailsFlow(hero: Flow<State<SuperHeroResponse>?>) {

    }

    override fun hideAllViews() {

    }

    private fun heroPower(overstates: SuperHeroPowerstats?) {
        val pie = AnyChart.radar()
        val data: MutableList<DataEntry> = ArrayList()
        data.add(ValueDataEntry("Intelligence", overstates?.intelligence?.toIntOrNull()))
        data.add(ValueDataEntry("Strength", overstates?.strength?.toIntOrNull()))
        data.add(ValueDataEntry("Speed", overstates?.speed?.toIntOrNull()))
        data.add(ValueDataEntry("Durability", overstates?.durability?.toIntOrNull()))
        data.add(ValueDataEntry("Power", overstates?.power?.toIntOrNull()))
        data.add(ValueDataEntry("Combat", overstates?.combat?.toIntOrNull()))
        pie.apply {
            data(data)
            yAxis(false)
            title("Hero Power stats")
            title().fontColor(ContextCompat.getColor(requireContext(), R.color.dark_blue).toString())
        }
    }


}
