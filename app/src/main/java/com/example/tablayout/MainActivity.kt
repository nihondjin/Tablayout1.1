package com.example.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.tablayout.adapter.PagerAdapter
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()

    }

    private fun initialize() {

        binding.viewPager2.adapter = PagerAdapter(this)
        binding.tableLayout.tabIconTint = null
        TabLayoutMediator(binding.tableLayout, binding.viewPager2) { tab, pos ->
            when (pos) {
                0 ->{
                    tab.setIcon(R.drawable.ic_baseline_camera_alt_24)
                        tab.icon?.setTint(ContextCompat.getColor(this, R.color.red))
                }
                1 ->{
                    tab.setIcon(R.drawable.ic_baseline_kitesurfing_24)
                        tab.icon?.setTint(ContextCompat.getColor(this, R.color.red))
                }
                2 ->{
                    tab.setIcon(R.drawable.ic_baseline_help_24)
                        tab.icon?.setTint(ContextCompat.getColor(this, R.color.red))
                }
            }
        }.attach()
        binding.tableLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    tab.icon?.alpha = 250
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    tab.icon?.alpha = 70
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }
}