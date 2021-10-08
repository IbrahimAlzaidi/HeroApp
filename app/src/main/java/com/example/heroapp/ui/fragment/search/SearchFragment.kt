package com.example.heroapp.ui.fragment.search

import android.view.LayoutInflater
import android.view.View
import com.example.heroapp.databinding.FragmentSearchBinding
import com.example.heroapp.ui.fragment.base.BaseFragment
import com.example.heroapp.ui.fragment.base.BasePresenter


class SearchFragment : BaseFragment<FragmentSearchBinding, BasePresenter>() {

    override val LOG_TAG: String = "Search Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate

    override val selectedPresenter = SearchPresenter()

    override fun setup() {
    }

    override fun addCallBack() {}


//            is State.Error -> {
//                binding?.searchError?.show()
//            }
//            is State.Loading -> {
//                binding?.progressLoading?.smoothToShow()
//            }
//            is State.Success -> {
//                binding?.search?.hide()
//            }


    private fun View.show() {
        this.visibility = View.VISIBLE
    }

    private fun View.hide() {
        this.visibility = View.GONE
    }

    private fun hideAllViews() {
        binding?.apply {
            binding?.search?.hide()
            searchError.hide()
            progressLoading.smoothToHide()
        }
    }
}