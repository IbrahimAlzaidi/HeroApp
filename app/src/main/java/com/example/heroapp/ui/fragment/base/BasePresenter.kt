package com.example.heroapp.ui.fragment.base

import com.example.heroapp.util.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlin.reflect.KFunction1

abstract class BasePresenter {
    val customScope = CoroutineScope(Dispatchers.Main)

    fun <T> handleRequest(
        response: Flow<State<T>>,
        onError: (String) -> Unit,
        onLoading: () -> Unit,
        onSuccess: KFunction1<T, Unit>?,
    ) {
        customScope.launch {
            response.flowOn(Dispatchers.IO)
                .catch { throwable ->
                    onError(throwable.message.toString())
                }.collect { state ->
                    state.handle(onError, onLoading, onSuccess)
                }
        }
    }

    private fun <T> State<T>.handle(
        onError: (String) -> Unit,
        onLoading: () -> Unit,
        onSuccess: KFunction1<T, Unit>?,
    ) {
        when (this) {
            is State.Error -> onError(message)
            State.Loading -> onLoading()
            is State.Success -> if (onSuccess != null) {
                onSuccess(data)
            }
        }
    }
}
