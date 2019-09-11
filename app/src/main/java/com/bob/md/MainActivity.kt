package com.bob.md

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bob.md.anim.AnimActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            Log.e(this.javaClass.simpleName, "onCreate -->" + savedInstanceState.getString("test"))
        } else {
            Log.e(this.javaClass.simpleName, "onCreate -->" + "savedInstanceState == null")
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(this.javaClass.simpleName, "onRestoreInstanceState -->" + savedInstanceState.getString("test"))
    }

    override fun onResume() {
        super.onResume()

        tvAnimSet.setOnClickListener{
            startActivity(Intent(this@MainActivity, AnimActivity::class.java))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("test", "我被销毁了")
    }
}
