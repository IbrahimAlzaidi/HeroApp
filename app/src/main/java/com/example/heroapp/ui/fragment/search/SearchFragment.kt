package com.example.heroapp.ui.fragment.search

import android.view.LayoutInflater
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.example.heroapp.databinding.FragmentSearchBinding
import com.example.heroapp.model.Repository
import com.example.heroapp.model.response.heroImageModel.HeroImage
import com.example.heroapp.model.response.heroModel.Heros
import com.example.heroapp.ui.ViewPagerAdapter
import com.example.heroapp.ui.fragment.base.BaseFragment
import com.example.heroapp.ui.fragment.base.BasePresenter
import com.example.heroapp.util.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class SearchFragment : BaseFragment<FragmentSearchBinding,BasePresenter>(),ISearchView {
    private val imageHeroList = mutableListOf<HeroImage>()
    override val LOG_TAG: String
        get() = "Main Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate
    override val selectedPresenter = SearchPresenter()

    override fun setup() {
        selectedPresenter.view = this
        selectedPresenter.getResultOfSearch()
    }
    override fun addCallBack() {
//        binding?.mySearchField?.doOnTextChanged { text, _, _, _ ->
//            if (!text.isNullOrEmpty())
//                flowData(text.toString())
//        }
    }

    override fun onSearchSuccess(hero: Heros) {
        binding?.mySearchField?.doOnTextChanged { text, _, _, _ ->
            if (!text.isNullOrEmpty())
                flowData(text.toString())
        }
    }

    private fun flowData(text: String) {
        val myFlow = Repository.getHeroImage(text).flowOn(Dispatchers.IO)
        lifecycleScope.launch {
            myFlow.collect {
                onHeroResult(it)
            }
        }
    }

    private fun onHeroResult(response: State<Heros>) {
        when (response) {
            is State.Error -> {
            }
            is State.Loading -> {
            }
            is State.Success -> {
                bindData(response.data)
            }
        }
    }

    private fun bindData(data: Heros) {
        binding?.recyclerView?.apply {
            adapter = ViewPagerAdapter(data)
        }
    }
}

