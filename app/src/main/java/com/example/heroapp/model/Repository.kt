package com.example.heroapp.model

import com.example.heroapp.model.network.Client
import com.example.heroapp.util.State
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow

object Repository {
    @FlowPreview
    fun getHeroImage(heroName: String) = getHeroDetails(heroName).flatMapConcat {
        when (it) {
            is State.Error -> {
                flow {
                    emit(it)
                }
            }
            is State.Loading -> {
                flow {
                    emit(it)
                }
            }
            is State.Success -> {
                flow {
                    if (it.data.results.isNullOrEmpty()) {
                        emit(State.Error("Data Not Found"))
                    } else {
                        emit(
                            Client.makeRequestToGetHeroDetails(it.data.results[0].name!!)
                        )
                    }
                }
            }
        }
    }

    private fun getHeroDetails(heroName: String) = flow {
        emit(State.Loading)
        emit(Client.makeRequestToGetHeroDetails(heroName))
    }
}
