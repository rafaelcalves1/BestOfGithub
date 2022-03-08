package com.rafa.bestofgithub.presenter.splash.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.rafa.bestofgithub.R
import com.rafa.bestofgithub.presenter.home.activity.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            delay(1000)
            Intent(this@MainActivity, HomeActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}