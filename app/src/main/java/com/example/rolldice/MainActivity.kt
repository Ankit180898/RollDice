package com.example.rolldice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.rolldice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding //Data binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vibe:Vibrator= getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        val rollBtn: Button = binding.button     //findViewById(R.id.button)
        rollBtn.setOnClickListener {
            val animation:Animation=AnimationUtils.loadAnimation(applicationContext, R.anim.shake)
            binding.imageView.startAnimation(animation)
            vibe.vibrate(50)
            roll()
        }
    }

    private fun roll() {
        val randomNum= Random.nextInt(1,7)
        val dice:ImageView=binding.imageView     //findViewById(R.id.imageView)
        when(randomNum){
            1-> dice.setImageResource(R.drawable.one)
            2-> dice.setImageResource(R.drawable.two)
            3-> dice.setImageResource(R.drawable.three)
            4-> dice.setImageResource(R.drawable.four)
            5-> dice.setImageResource(R.drawable.five)
            6-> dice.setImageResource(R.drawable.six)
        }

    }
}