package com.example.teamproject

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.teamproject.databinding.ActivityMain2Binding
import com.example.teamproject.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : FragmentActivity(), BottomNavigationView.OnNavigationItemSelectedListener  {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bn.setOnNavigationItemSelectedListener(this)

        supportFragmentManager.beginTransaction().add(R.id.fl, HomeFragment()).commit()


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.homeIcon -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl, HomeFragment()).commitAllowingStateLoss()
                return true
            }
            R.id.settingIcon -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl, SettingFragment()).commitAllowingStateLoss()
                return true
            }
        }
        return false
    }

    fun changeFragment(index: Int) {
        when(index) {
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl, CalendarFragment())
                    .commit()
            }
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl, DiaryviewFragment())
                    .commit()
            }
            3 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl, MapFragment())
                    .commit()
            }
        }
    }
}

