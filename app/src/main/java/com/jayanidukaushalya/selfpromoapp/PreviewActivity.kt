package com.jayanidukaushalya.selfpromoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jayanidukaushalya.selfpromoapp.databinding.ActivityMainBinding
import com.jayanidukaushalya.selfpromoapp.databinding.ActivityPreviewBinding

class PreviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.textviewMessage.text = getIntentData()
    }

    private fun getIntentData(): String {
        val contactName = intent.getStringExtra("contactName")
        val contactNumber = intent.getStringExtra("contactNumber")
        val displayName = intent.getStringExtra("displayName")
        val isJunior = intent.getBooleanExtra("isJunior", false)
        val jobTitle = intent.getStringExtra("jobTitle")
        val isImmediateStart = intent.getBooleanExtra("isImmediateStart", false)
        val startDate = intent.getStringExtra("startDate")

        return "Contact Name: $contactName, Contact Number: $contactNumber, Display Name: $displayName, Is Junior: $isJunior, Job Title: $jobTitle, Is Immediate Start: $isImmediateStart, Start Date: $startDate"
    }
}