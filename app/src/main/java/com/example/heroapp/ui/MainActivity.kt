package com.example.heroapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.heroapp.R
import com.example.heroapp.databinding.ActivityMainBinding
import com.example.heroapp.ui.fragment.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val mainFragment = MainFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        supportFragmentManager.beginTransaction().add(R.id.container, mainFragment).commit()
    }

}
