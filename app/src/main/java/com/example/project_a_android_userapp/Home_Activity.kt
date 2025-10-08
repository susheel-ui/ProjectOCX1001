package com.example.project_a_android_userapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.project_a_android_userapp.Fragements.HistoryFragment
import com.example.project_a_android_userapp.Fragements.HomeFragment
import com.example.project_a_android_userapp.Fragements.PaymentFragment
import com.example.project_a_android_userapp.Fragements.UserFragment
import com.example.project_a_android_userapp.databinding.ActivityHomeBinding

class Home_Activity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try {
            changeFragment(HomeFragment())
        } catch (e: Exception) {
            Log.d(TAG, "onCreate: error ${e.message}")
        }
     binding.bottomNavigation.setOnItemSelectedListener {
         when (it.itemId) {
             R.id.nav_home -> {
                 changeFragment(HomeFragment())
             }
             R.id.nav_orders -> {
                 changeFragment(HistoryFragment())
             }
             R.id.nav_payments -> {
                 changeFragment(PaymentFragment())
             }
             R.id.nav_account -> {
                 changeFragment(UserFragment())
             }
             else -> {
                false
             }
         }
     }

    }
    fun changeFragment(fragment:Fragment):Boolean{
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerViewTag.id, fragment)
            .commit()
        return true
    }
}