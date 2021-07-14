package com.shwjdqls.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.shwjdqls.test.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.menu.setOnClickListener {
            if (!binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.openDrawer(GravityCompat.START)
            }
        }

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.matching, R.id.rating, R.id.community, R.id.contents -> supportFragmentManager.beginTransaction().replace(binding.frameLayout.id, EmptyFragment()).commit()
                R.id.like -> supportFragmentManager.beginTransaction().replace(binding.frameLayout.id, LikeFragment()).commit()
            }
            true
        }
    }
}
