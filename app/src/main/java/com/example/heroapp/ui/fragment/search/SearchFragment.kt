package com.example.heroapp.ui.fragment.search

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.heroapp.databinding.FragmentSearchBinding
import com.example.heroapp.model.response.heroModel.Heros
import com.example.heroapp.model.response.heroModel.Result
import com.example.heroapp.ui.fragment.base.BaseFragment
import com.example.heroapp.ui.fragment.base.BaseInterFace
import com.example.heroapp.ui.fragment.base.BasePresenter
import com.example.heroapp.util.State
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

    override fun onDataFlow(hero: Flow<State<Heros>>) {
        selectedPresenter.handleRequest(hero, ::onSearchError, ::onSearchLoading, ::onSearchSuccess)
    }

    override fun onSearchSuccess(hero: Heros) {
        hideAllViews()
        binding?.recyclerView?.apply {
            adapter = SearchAdapter(hero, this@SearchFragment)
        }?.show()
    }

    override fun onCardClicked(hero: Result?) {
        Toast.makeText(requireContext(), hero?.name, Toast.LENGTH_SHORT).show()
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

    override fun View.show() {
        this.visibility = View.VISIBLE
    }

    override fun View.hide() {
        this.visibility = View.GONE
    }

    override fun hideAllViews() {
        binding?.apply {
            search.hide()
            searchError.hide()
            progressLoading.smoothToHide()
        }
    }

}
