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
            title = "あいうえお株式会社"
            setDisplayHomeAsUpEnabled(true)
        }
    }
}