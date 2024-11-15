package com.hamza.animation

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var card: CardView
    lateinit var rotateButton: Button
    lateinit var scale: Button
    lateinit var translateButton: Button
    lateinit var slideUp: Button
    lateinit var slideDown: Button
    lateinit var slideLeft: Button
    lateinit var slideRight: Button
    lateinit var fadeIn: Button
    lateinit var fadeOut: Button
    lateinit var zoomIn: Button
    lateinit var zoomOut: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        card = findViewById(R.id.imgvw)
        rotateButton = findViewById<Button>(R.id.Rotate)
        translateButton = findViewById<Button>(R.id.translate)
        slideUp = findViewById<Button>(R.id.SlideUp)
        slideDown = findViewById<Button>(R.id.SlideDown)
        slideLeft = findViewById<Button>(R.id.SlideLeft)
        slideRight = findViewById<Button>(R.id.SlideRight)
        fadeIn = findViewById<Button>(R.id.btnFadeIn)
        fadeOut = findViewById<Button>(R.id.btnFadeOut)
        zoomIn = findViewById<Button>(R.id.zoomIn)
        zoomOut = findViewById<Button>(R.id.zoomOut)
        scale = findViewById<Button>(R.id.Scale)

        zoomOut.setOnClickListener{
            val animZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
            card.startAnimation(animZoomOut)
        }

        zoomIn.setOnClickListener{
            val animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
            card.startAnimation(animZoomIn)
        }

        slideUp.setOnClickListener{
            val animSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
            card.startAnimation(animSlideUp)
        }

        slideDown.setOnClickListener{
            val animSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
            card.startAnimation(animSlideDown)
        }

        slideLeft.setOnClickListener{
            val animSlideLeft = AnimationUtils.loadAnimation(this, R.anim.slide_left)
            card.startAnimation(animSlideLeft)
        }

        slideRight.setOnClickListener{
            val animSlideRight = AnimationUtils.loadAnimation(this, R.anim.slide_right)
            card.startAnimation(animSlideRight)
        }

        fadeIn.setOnClickListener{
            val animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fide_in)
            card.startAnimation(animFadeIn)
        }

        fadeOut.setOnClickListener{
            val animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fide_out)
            card.startAnimation(animFadeOut)
        }

        rotateButton.setOnClickListener{
            rotater()
        }

        translateButton.setOnClickListener{
            translater()
        }

        scale.setOnClickListener{
            scaler()
        }
    }

    private fun rotater() {
        val animator = ObjectAnimator.ofFloat(card, View.ROTATION, -360f, 0f)
        animator.duration = 1000
        animator.start()
    }

    private fun translater() {
        val animator = ObjectAnimator.ofFloat(card, View.TRANSLATION_X, 200f)
        animator.repeatCount = 1
        animator.duration = 1500
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    private fun scaler() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            card, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }
}