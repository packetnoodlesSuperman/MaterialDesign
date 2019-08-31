package com.bob.md.anim

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import com.bob.md.MainActivity
import com.bob.md.R
import kotlinx.android.synthetic.main.activity_anim_transition.*

/**
 * Activity的转场动画
 */
class TransitionAnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim_transition)
    }

    /**
     * 转场动画的种类
     * 1. 进入
     * 2. 退出
     * 3. 共享元素 一个共享元素过度动画决定两个Activity之间的过渡,怎么共享他们的视图.
     */
    override fun onResume() {
        super.onResume()

        //传统方式 overridePendingTransition
        tvAnimOverridePendingTransition.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.enter_up, R.anim.exit_down)
        }

        //转场动画 makeBasic
        tvAnimTransitionMakeBasic.setOnClickListener{
            var compat = ActivityOptionsCompat
                .makeBasic()

            ActivityCompat.startActivity(this,
                Intent(this@TransitionAnimActivity, MainActivity::class.java),
                compat.toBundle())
        }

        //转场动画 makeClipRevealAnimation  圆形循环揭露
        //参数类型，依次为:操作view，
        //                 SecondActivity开始渐变点横坐标，
        //                 SecondActivity开始渐变点纵坐标，
        //                 SecondActivity要扩展的初始圆半径，
        //                 SecondActivity要扩展的最终圆半径
        tvAnimTransitionMakeClipRevealAnimation.setOnClickListener{
            var compat = ActivityOptionsCompat
                //传入view，起始点坐标，
                // 起始宽高  //让新的Activity从一个小的范围扩大到全屏
                .makeClipRevealAnimation(tvAnimTransitionMakeClipRevealAnimation,
                tvAnimTransitionMakeClipRevealAnimation.left+ tvAnimTransitionMakeClipRevealAnimation.width/2,
                tvAnimTransitionMakeClipRevealAnimation.top+tvAnimTransitionMakeClipRevealAnimation.height/2,
                       0,
                    0)

            ActivityCompat.startActivity(this,
                Intent(this@TransitionAnimActivity, MainActivity::class.java),
                compat.toBundle())
        }

        //转场动画 makeCustomAnimation 自定义动画
        //和overridePendingTransition使用非常类似，传入context、进入和退出动画anim资源
        tvAnimTransitionMakeCustomAnimation.setOnClickListener{
            var compat = ActivityOptionsCompat
                .makeCustomAnimation(this, R.anim.enter_up, R.anim.exit_down)

            ActivityCompat.startActivity(this,
                Intent(this@TransitionAnimActivity, MainActivity::class.java),
                compat.toBundle())
        }

        //转场动画 makeScaleUpAnimation  渐变缩放转场动画
        //和makeClipRevealAnimation在参数上没有变化
        tvAnimTransitionMakeScaleUpAnimation.setOnClickListener{
            var compat = ActivityOptionsCompat
                .makeScaleUpAnimation(tvAnimTransitionMakeScaleUpAnimation,
                    tvAnimTransitionMakeScaleUpAnimation.width/2,
                    tvAnimTransitionMakeScaleUpAnimation.height/2,
                    0,
                    0)

            ActivityCompat.startActivity(this,
                Intent(this@TransitionAnimActivity, MainActivity::class.java),
                compat.toBundle())
        }

        //转场动画 共享元素
        //第二参数传入过渡的view，第三个参数传入 android:transitionName 标识名称
        tvAnimTransitionMakeSceneTransitionAnimation.setOnClickListener{
            var compat = ActivityOptionsCompat
                .makeSceneTransitionAnimation(
                    this@TransitionAnimActivity,
                    tvAnimTransitionMakeSceneTransitionAnimation,
                    "tvAnimTransitionMakeSceneTransitionAnimation"
                )

            ActivityCompat.startActivity(this,
                Intent(this@TransitionAnimActivity, MainActivity::class.java),
                compat.toBundle())
        }


    }

}