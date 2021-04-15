package com.example.iplocator.menu_activities

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.iplocator.databinding.ActivityDeviceInformationBinding


class DeviceInformation : AppCompatActivity() {
    lateinit var binding: ActivityDeviceInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeviceInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.versionRelease.text = "VERSION.RELEASE : ${Build.VERSION.RELEASE}"
        binding.versionInc.text = "VERSION.INCREMENTAL : ${Build.VERSION.INCREMENTAL}"
        binding.versionSdk.text = "VERSION.SDK.NUMBER : ${Build.VERSION.SDK_INT}\n"
        binding.board.text = "BOARD : ${Build.BOARD}\n"
        binding.brand.text = "BRAND : ${Build.BRAND}\n"
        binding.display.text = "DISPLAY : ${Build.DISPLAY}\n"
        binding.fingerprint.text = "FINGERPRINT : ${Build.FINGERPRINT}\n"
        binding.hardware.text = "HARDWARE : ${Build.HARDWARE}\n"
        binding.host.text = "HOST : ${Build.HOST}\n"
        binding.id.text = "ID : ${Build.ID}\n"
        binding.manufacturer.text = "MANUFACTURER : ${Build.MANUFACTURER}\n"
        binding.model.text = "MODEL : ${Build.MODEL}\n"

    }
}