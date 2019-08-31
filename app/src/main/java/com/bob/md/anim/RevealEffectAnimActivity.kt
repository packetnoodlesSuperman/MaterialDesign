package com.bob.md.anim

import android.os.Build
import android.os.Bundle
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.bob.md.R
import kotlinx.android.synthetic.main.activity_anim_reveal_effect.*

/**
 * 揭露动画
 */
class RevealEffectAnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim_reveal_effect)
    }

    override fun onResume() {
        super.onResume()

        //从中心点开启动画
        tvCircularRevealEffect.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                ViewAnimationUtils.createCircularReveal(
                    tvCircularRevealEffect,
                    tvCircularRevealEffect.width/2,
                    tvCircularRevealEffect.height/2,
                    0f,
                    tvCircularRevealEffect.height.toFloat()
                ).apply {
                    duration = 1000
                    interpolator = AccelerateInterpolator()
                }.start()
        }

        //从左下角开启动画
        tvCircularRevealEffect2.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                ViewAnimationUtils.createCircularReveal(
                    tvCircularRevealEffect2,
                    0,
                    tvCircularRevealEffect2.height,
                    0f,
                    Math.hypot(
                        tvCircularRevealEffect2.width.toDouble(),
                        tvCircularRevealEffect2.height.toDouble()
                    ).toFloat()
                ).apply {
                    duration = 1000
                    interpolator = AccelerateInterpolator()
                }.start()
        }
    }

}