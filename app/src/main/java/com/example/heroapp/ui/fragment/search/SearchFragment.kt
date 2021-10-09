package com.example.heroapp.ui.fragment.search

import android.view.LayoutInflater
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.example.heroapp.databinding.FragmentSearchBinding
import com.example.heroapp.model.response.heroImageModel.HeroImage
import com.example.heroapp.model.response.heroModel.Heros
import com.example.heroapp.ui.ViewPagerAdapter
import com.example.heroapp.ui.fragment.base.BaseFragment
import com.example.heroapp.ui.fragment.base.BaseInterFace
import com.example.heroapp.ui.fragment.base.BasePresenter
import com.example.heroapp.util.State
import kotlinx.coroutines.flow.Flow


class SearchFragment : BaseFragment<FragmentSearchBinding, BasePresenter>(), BaseInterFace,
    ISearchView {
    private val imageHeroList = mutableListOf<HeroImage>()
    override val LOG_TAG: String
        get() = "Main Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate
    override val selectedPresenter = SearchPresenter(this)
    override fun setup() {
        binding?.mySearchField?.doOnTextChanged { text, _, _, _ ->
            if (!text.isNullOrEmpty())
                selectedPresenter.getResultOfSearch(text.toString())
        }
    }

    override fun addCallBack() {}

    override fun onDataFlow(hero: Flow<State<Heros>>) {
        selectedPresenter.handleRequest(hero, ::onSearchError, ::onSearchLoading, ::onSearchSuccess)
    }

    override fun onSearchSuccess(hero: Heros) {
        hideAllViews()
        binding?.recyclerView?.apply {
            adapter = ViewPagerAdapter(hero)
        }?.show()
    }

    override fun onSearchError(message: String) {
        binding?.searchError?.show()  //here View is adding for show Lottie
        binding?.search?.hide()
        binding?.recyclerView?.hide()
        binding?.progressLoading?.smoothToHide()
    }

    override fun onSearchLoading() {
        binding?.searchError?.hide()
        binding?.search?.hide()
        binding?.progressLoading?.smoothToShow() //here progressLoading View is adding for show progress bar
    }

    override fun View.show() {
        this.visibility = View.VISIBLE
    }

    override fun View.hide() {
        this.visibility = View.GONE
    }

    override fun hideAllViews() {
        binding?.search?.hide()
        binding?.searchError?.hide()
        binding?.progressLoading?.smoothToHide()
    }


}
