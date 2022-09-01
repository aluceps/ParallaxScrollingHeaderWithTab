package me.aluceps.parallaxscrollingheaderwithtab

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.aluceps.parallaxscrollingheaderwithtab.databinding.ActivityTabBinding

class TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTabBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "あいうえお株式会社"
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean =
        onBackPressed().let {
            true
        }

    companion object {
        fun start(context: Context) = context.startActivity(
            Intent(context, TabActivity::class.java)
        )
    }
}
