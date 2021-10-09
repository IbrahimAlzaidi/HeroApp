package com.example.heroapp.ui.fragment.search

import android.view.LayoutInflater
import androidx.core.widget.doOnTextChanged
import com.example.heroapp.databinding.FragmentSearchBinding
import com.example.heroapp.model.response.heroModel.SuperHeroResponse
import com.example.heroapp.model.response.heroModel.SuperHeroResult
import com.example.heroapp.ui.fragment.base.BaseFragment
import com.example.heroapp.ui.fragment.base.BaseInterFace
import com.example.heroapp.ui.fragment.base.BasePresenter
import com.example.heroapp.util.State
import com.example.heroapp.util.goToAnotherFragment
import com.example.heroapp.util.hide
import com.example.heroapp.util.show
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow

class SearchFragment : BaseFragment<FragmentSearchBinding, BasePresenter>(), BaseInterFace,
    ISearchView, IItemListener {

    override val LOG_TAG: String
        get() = "Main Fragment"

    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate

    override val selectedPresenter = SearchPresenter(this)

    override fun setup() {
        binding?.mySearchField?.doOnTextChanged { text, _, _, _ ->
            getInputTextAndSendToPresenter(text.toString())
        }
    }

    private fun getInputTextAndSendToPresenter(text: String) {
        if (!text.isNullOrEmpty())
            selectedPresenter.getResultOfSearch(text)
    }

    override fun addCallBack() {}

    override fun onDataSearchFlow(hero: Flow<State<SuperHeroResponse>>) {
        selectedPresenter.handleRequest(hero, ::onSearchError, ::onSearchLoading, ::onSearchSuccess)
    }

    override fun onSearchSuccess(hero: SuperHeroResponse) {
        hideAllViews()

        binding?.recyclerView?.apply {
            adapter = SearchAdapter(hero, this@SearchFragment)
        }?.show()
    }

    override fun onItemClickListener(hero: SuperHeroResult?) {
        hero?.let { SearchFragmentDirections.actionSearchFragmentToDetailsFragment(it) }?.let {
            view?.goToAnotherFragment(
                it
            )
        }
    }

    override fun onSearchError(message: String) {
        binding?.apply {
            searchError.show()
            search.hide()
            recyclerView.hide()
            progressLoading.smoothToHide()
        }
    }

    override fun onSearchLoading() {
        binding?.apply {
            searchError.hide()
            search.hide()
            progressLoading.smoothToShow()
        }
    }

    override fun hideAllViews() {
        binding?.apply {
            search.hide()
            searchError.hide()
            progressLoading.smoothToHide()
        }
    }

}
