package me.aluceps.parallaxscrollingheaderwithtab

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
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
        setupView(binding)
    }

    override fun onSupportNavigateUp(): Boolean =
        onBackPressed().let {
            true
        }

    private fun setupView(binding: ActivityTabBinding) {
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = (binding.viewPager.adapter as? ViewPagerAdapter)?.getTitle(position) ?: ""
        }.attach()
    }

    private class ViewPagerAdapter(
        manager: FragmentManager,
        lifecycle: Lifecycle,
    ) : FragmentStateAdapter(manager, lifecycle) {
        enum class Tabs(val title: String) {
            PAGE1("レシピ"),
            PAGE2("記事"),
        }

        fun getTitle(position: Int) =
            Tabs.values()[position].title

        override fun getItemCount(): Int =
            Tabs.values().size

        override fun createFragment(position: Int): Fragment =
            TabFragment.newInstance()
    }

    companion object {
        fun start(context: Context) = context.startActivity(
            Intent(context, TabActivity::class.java)
        )
    }
}
