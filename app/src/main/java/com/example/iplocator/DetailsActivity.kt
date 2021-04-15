package com.example.iplocator

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.iplocator.databinding.ActivityDetailsBinding
import com.example.iplocator.network_call.ApiFields
import com.example.iplocator.network_call.IpService
import com.example.iplocator.viewmodel.DetailsRepository
import com.example.iplocator.viewmodel.DetailsViewModel
import com.example.iplocator.viewmodel.DetailsViewModelFactory

class DetailsActivity : AppCompatActivity() {

    private var latitude: Double = 0.0

    private var longitude: Double = 0.0

    private val retrofitService = IpService.ipInstance

    lateinit var binding: ActivityDetailsBinding

    lateinit var ipDetails: ApiFields

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val ipAddress: String? = intent.getStringExtra("address")

        val viewModelFactory =
            DetailsViewModelFactory(DetailsRepository(retrofitService, ipAddress!!))

        val viewModel = ViewModelProvider(this, viewModelFactory).get(DetailsViewModel::class.java)

        viewModel.data.observe(this, Observer {

            ipDetails = viewModel.data.value!!

            if (ipDetails.status == "success") {
                binding.queryTextView.text = "IP Address:- " + ipDetails.query
                binding.countryTextView.text = "Country:- " + ipDetails.country
                binding.regionTextView.text = "Region:- " + ipDetails.regionName
                binding.cityTextView.text = "City:- " + ipDetails.city
                binding.longitudeTextView.text =
                    "Longitude:- " + ipDetails.lon.toString()
                longitude = ipDetails.lon.toDouble()
                binding.latitudeTextView.text = "Latitude:- " + ipDetails.lat.toString()
                latitude = ipDetails.lat.toDouble()
                binding.zipTextView.text = "ZIP:- " + ipDetails.zip
                binding.timezoneTextView.text = "TimeZone:- " + ipDetails.timezone
                binding.ispTextView.text = "ISP:- " + ipDetails.isp
            } else {
                binding.detailsView.visibility = View.GONE
                binding.errorTextView.visibility = View.VISIBLE
            }
        })

        viewModel.errorMessage.observe(this, Observer {
        })

        viewModel.getDetails()


        binding.locateButton.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("Latitude", latitude)
            intent.putExtra("Longitude", longitude)
            startActivity(intent)
        }
    }
}