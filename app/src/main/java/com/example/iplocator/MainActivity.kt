package com.example.iplocator

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.iplocator.databinding.ActivityMainBinding
import com.example.iplocator.menu_activities.DeviceInformation
import com.example.iplocator.menu_activities.WhatIsIP


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val connected = isNetworkAvailable()

        if (!connected) {
            binding.imageView.visibility = View.VISIBLE
            binding.childConstraint.visibility = View.GONE
        }


        binding.submitButton.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            val ipAddress = binding.ipEditText.text.toString()
            intent.putExtra("address", ipAddress)
            startActivity(intent)
        }

    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.whatIsIP -> {
                val intent = Intent(this, WhatIsIP::class.java)
                startActivity(intent)
            }
            R.id.deviceInfo -> {
                val intent = Intent(this, DeviceInformation::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}