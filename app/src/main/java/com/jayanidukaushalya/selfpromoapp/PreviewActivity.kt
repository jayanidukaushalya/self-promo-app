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
        val message = intent.getSerializableExtra("message", Message::class.java)

        return """
            Hi ${message?.contactName},
            
            My name is ${message?.displayName} and I am ${message?.getFullDescription()}.
            
            I have a portfolio of apps to demonstrate my technical skills that I can show on request.
            
            I am able to start a new position ${message?.getAvailability()}.
            
            Please get in touch if you have any suitable roles for me.
            
            Thanks and best regards.
        """.trimIndent()
    }
}