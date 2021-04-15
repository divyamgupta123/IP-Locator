package com.example.iplocator.menu_activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.example.iplocator.databinding.ActivityWhatIsIPBinding

class WhatIsIP : AppCompatActivity() {
    lateinit var binding: ActivityWhatIsIPBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatIsIPBinding.inflate(layoutInflater)

        binding.ipParagraphTextView.text =
            "IP (Internet Protocol) Address is an address of your network hardware. It helps in connecting your computer to other devices on your network and all over the world. An IP Address is made up of numbers or characters.\n" +
                    "\n" +
                    "An example of an IP address would be: 506.457.14.512\n" +
                    "\n" +
                    "All devices that are connected to an internet connection have a unique IP address which means there’s a need of billions of IP addresses. This requirement is fulfilled by the new IP version IPv6.\n" +
                    "\n" +
                    "There are are two IP versions: IPv4 and IPv6. IPv4 is the older version which has an space of over 4 billion IP addresses. However, the new IPv6 version can provide up to trillions of IP addresses to fulfill the need of all internet users and devices.\n" +
                    "\n" +
                    "The IPv4 version used to configure IP addresses in numerical value (numbers) which may conflict with other IP addresses. That’s why IPv6 adopted the hexadecimal method to provide unique IP addresses to billions of users in the world.\n" +
                    "\n" +
                    "Example of an IPv6 IP address would be:\n" +
                    "\n" +
                    "4ggr:1925:5656:7:600:t4tt:tc54:98vt\n" +
                    "\n" +
                    "There are a few types of IP addresses like private IP addresses, public IP addresses, static IP addresses and dynamic IP addresses"


        binding.linkTextView.movementMethod = LinkMovementMethod.getInstance()
        setContentView(binding.root)
    }
}