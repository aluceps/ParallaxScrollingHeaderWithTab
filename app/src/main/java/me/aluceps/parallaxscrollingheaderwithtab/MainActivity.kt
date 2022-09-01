package me.aluceps.parallaxscrollingheaderwithtab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.aluceps.parallaxscrollingheaderwithtab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "画面選択"
        }
        setupView(binding)
    }

    private fun setupView(binding: ActivityMainBinding) {
        binding.button1.setOnClickListener {
            NormalActivity.start(this)
        }

        binding.button2.setOnClickListener {
            TabActivity.start(this)
        }
    }
}
