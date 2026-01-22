package com.jayanidukaushalya.selfpromoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.jayanidukaushalya.selfpromoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnPreview.setOnClickListener {
            // Toast.makeText(this, "Button click works in Kotlin!", Toast.LENGTH_SHORT).show()
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        binding.spJobTitle.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {
        val contactName = binding.contactName.text.toString()
        val contactNumber = binding.contactNumber.text.toString()
        val displayName = binding.displayName.text.toString()
        val isJunior = binding.cbIncludeJunior.isChecked
        val jobTitle = binding.spJobTitle.selectedItem?.toString()
        val isImmediateStart = binding.cbImmediateStart.isChecked
        val startDate = binding.startDate.text.toString()

        // Toast.makeText(this, "Contact Name: $contactName, Contact Number: $contactNumber, Display Name: $displayName, Is Junior: $isJunior, Job Title: $jobTitle, Is Immediate Start: $isImmediateStart, Start Date: $startDate", Toast.LENGTH_LONG).show()

        val previewIntent = Intent(this, PreviewActivity::class.java)

        previewIntent.putExtra("contactName", contactName)
        previewIntent.putExtra("contactNumber", contactNumber)
        previewIntent.putExtra("displayName", displayName)
        previewIntent.putExtra("isJunior", isJunior)
        previewIntent.putExtra("jobTitle", jobTitle)
        previewIntent.putExtra("isImmediateStart", isImmediateStart)
        previewIntent.putExtra("startDate", startDate)

        startActivity(previewIntent)
    }
}