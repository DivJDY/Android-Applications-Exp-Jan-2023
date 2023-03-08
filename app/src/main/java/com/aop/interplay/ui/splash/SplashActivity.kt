package com.aop.interplay.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aop.interplay.MainActivity
import com.aop.interplay.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.videoViewId) {
            setVideoURI(viewModel.getPathUri())
            start()
            setOnCompletionListener {
                startActivity(
                    Intent(
                        this@SplashActivity, MainActivity::class.java
                    )
                )
                finish()
            }
        }
    }
}
