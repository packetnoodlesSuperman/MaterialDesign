package com.bob.md.anim

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bob.md.R
import kotlinx.android.synthetic.main.activity_anim_set.*

class AnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim_set)
    }

    override fun onResume() {
        super.onResume()
        tvAnimRipple.setOnClickListener{
            startActivity(Intent(this@AnimActivity, RippleAnimActivity::class.java))
        }

        tvAnimRevealEffect.setOnClickListener{
            startActivity(Intent(this@AnimActivity, RevealEffectAnimActivity::class.java))
        }

        tvAnimTransition.setOnClickListener{
            startActivity(Intent(this@AnimActivity, TransitionAnimActivity::class.java))
        }

        tvAnimSVG.setOnClickListener{
            startActivity(Intent(this@AnimActivity, SVGAnimActivity::class.java))
        }
    }

}