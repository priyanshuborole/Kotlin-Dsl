package com.priyanshub.messagemate.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.priyanshub.messagemate.onboarding.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private val onboardingImagesList =
        listOf(R.drawable.onboard1, R.drawable.onboard2, R.drawable.onboard3)
    private var page = 1
    private lateinit var binding: ActivityOnboardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)
        initViews()
        setUpClickListener()
    }

    private fun initViews(){
        binding.page1.setBackgroundColor(ContextCompat.getColor(this@OnboardingActivity,
            com.priyanshub.messagemate.central.R.color.colorPrimaryVariant))
        binding.tvOnboard.text = getString(com.priyanshub.messagemate.central.R.string.onboard_msg_1)
        binding.ivOnboardImage.setImageResource(onboardingImagesList[page - 1])
    }
    private fun setUpClickListener() {
        binding.btnOnboardNext.setOnClickListener {
            page+=1
            setupOnboardingPage()
        }
    }

    private fun setupOnboardingPage() {
        when (page) {
            1 -> {
                binding.tvOnboard.text = getString(com.priyanshub.messagemate.central.R.string.onboard_msg_1)
                binding.ivOnboardImage.setImageResource(onboardingImagesList[page - 1])
            }
            2 -> {
                binding.tvOnboard.text = getString(com.priyanshub.messagemate.central.R.string.onboard_msg_2)
                binding.ivOnboardImage.setImageResource(onboardingImagesList[page - 1])
                binding.page2.setBackgroundColor(ContextCompat.getColor(this@OnboardingActivity,
                    com.priyanshub.messagemate.central.R.color.colorPrimaryVariant))
            }
            3 -> {
                binding.tvOnboard.text = getString(com.priyanshub.messagemate.central.R.string.onboard_msg_3)
                binding.ivOnboardImage.setImageResource(onboardingImagesList[page - 1])
                binding.btnOnboardNext.text = getString(com.priyanshub.messagemate.central.R.string.get_started)
                binding.btnOnboardSkip.visibility = View.GONE
                binding.page3.setBackgroundColor(ContextCompat.getColor(this@OnboardingActivity,
                    com.priyanshub.messagemate.central.R.color.colorPrimaryVariant))
            }
        }
    }

}