package com.example.heroapp.ui.fragment

import android.view.LayoutInflater
import androidx.viewpager2.widget.ViewPager2
import com.example.heroapp.databinding.FragmentMainBinding
import com.example.heroapp.ui.ViewPagerAdapter
import com.example.heroapp.ui.model.heroImageModel.HeroImage


class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val LOG_TAG: String = "Main Fragment"

    private val imageHeroList = mutableListOf<HeroImage>()

    override val bindingInflater: (LayoutInflater) -> FragmentMainBinding =
        FragmentMainBinding::inflate

    override fun setup() {
        viewPagerSetup()
    }
    override fun addCallBack() {}

    private fun viewPagerSetup(){
        binding?.myViewPager?.apply {
            adapter = ViewPagerAdapter(imageHeroList)
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }
    private fun setImageDataList(data: HeroImage){
        imageHeroList.add(data)
    }
}
