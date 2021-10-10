package com.example.heroapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.goToAnotherFragment(navDirector: NavDirections){
    Navigation.findNavController(this).navigate(navDirector)
}