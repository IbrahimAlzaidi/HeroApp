package com.example.heroapp.ui.fragment.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.cancel

abstract class BaseFragment<VB : ViewBinding, PR : BasePresenter> : Fragment() {
    abstract val LOG_TAG: String
    abstract val bindingInflater: (LayoutInflater) -> VB

    private lateinit var _binding: ViewBinding
    var binding: VB?
        get() = _binding as VB?
        set(value) = TODO()

    private lateinit var _presenter: BasePresenter
    var presenter: PR?
        get() = _presenter as PR?
        set(value) = TODO()

    abstract val selectedPresenter: BasePresenter

    abstract fun setup()

    abstract fun addCallBack()

//    abstract fun View.show()
//    abstract fun View.hide()
    abstract fun hideAllViews()

    protected fun log(value: String) {
        Log.v(LOG_TAG, value)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        addCallBack()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _presenter = selectedPresenter

        return bindingInflater(layoutInflater).apply { _binding = this }.root
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.customScope?.cancel()
    }

}
